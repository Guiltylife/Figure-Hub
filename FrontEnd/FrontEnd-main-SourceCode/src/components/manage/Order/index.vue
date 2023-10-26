<template>
  <div>
    <div class="flextitle">
    </div>
    <div>
      <a-modal
          title="确认收货"
          :visible="visible"
          @ok="handleOk(1)"
          @cancel="handleCancel"
      >
        <p>要确认收货吗？确认后不可撤销！</p>
      </a-modal>
      <a-table
          bordered
          :pagination="pagination"
          :columns="columns"
          :data-source="data"
          :loading="loading"
          rowKey="dealId"
      >
        <template slot="operation" slot-scope="text, record">
          <a-button type="link" @click="confirmModal(record)" v-if="record.status===0">确认收货</a-button>
          <a-button type="link" @click="commentModal(record)" v-else-if="record.status===1">我要评论</a-button>
          <a-button type="link" @click="showComModal(record)" v-else>查看评论</a-button>
          <a-popconfirm
              v-if="data.length"
              title="确定要取消此交易吗?"
              ok-text="确定"
              cancel-text="取消"
              @confirm="() => onDelete(record.dealId)"
          >
            <a-button type="link" click="javascript:;">删除订单</a-button>
          </a-popconfirm>
        </template>
      </a-table>
      <update-form
          ref="updateForm"
          :visible="updatevisible"
          :recorder="updateRecorder"
          @cancel="updateCancel"
          @create="updateCreate"
      />
    </div>
  </div>
</template>

<script>
import CollectionCreateForm from "./form/createform.vue";
import UpdateForm from "./form/updateform.vue";
import axios_service from "@/api/request";

export default {
  components: {
    CollectionCreateForm,
    UpdateForm,
  },
  data() {
    return {
      pagination: {
        defaultPageSize: 7,
        showTotal: (total) => `共${total}条数据`,
      },
      columns: [
        {
          title: "单号",
          dataIndex: "dealId",
          key: "dealId",
          width: "5%",
        },
        {
          title: "卖家",
          dataIndex: "seller",
          key: "seller",
          width: "10%",
        },
        {
          title: "手办名称",
          dataIndex: "figureName",
          key: "figureName",
          width: "40%",
        },
        {
          title: "时间",
          dataIndex: "createTime",
          key: "createTime",
          width: "15%",
        },
        {
          title: "状态",
          dataIndex: "statusStr",
          key: "statusStr",
        },
        {
          title: "操作",
          width: "20%",
          dataIndex: "operation",
          scopedSlots: {
            customRender: "operation",
          },
        },
      ],
      data: [],
      visible: false,
      updatevisible: false,
      showvisible: false,
      loading: false,
      searchType: 0,
      updateRecorder: {},
    };
  },
  methods: {
    showComModal(record) {
      axios_service.get("dealcomment/selectByDealId?dealId=" + record.dealId,null).then((res) => {
        console.log(res[0]);
        const h = this.$createElement;
        this.$info({
          title: '查看评论',
          content: h('div', {}, [
            h('p', res[0].content),
          ]),
          onOk() {
          },
        });
      });
    },
    formData() {
      for (let i = 0; i < this.data.length; i++) {
        let tmp_gender = this.data[i].status;
        if (tmp_gender == 2) {
          this.data[i].statusStr = "已完成";
        } else if (tmp_gender == 1) {
          this.data[i].statusStr = "待评价";
        } else {
          this.data[i].statusStr = "待收货";
        }
      }
    },
    selectChange(value) {
      this.searchType = value;
      console.log(this.searchType);
    },
    onCellChange(key, dataIndex, value) {
      const dataSource = [...this.dataSource];
      const target = dataSource.find((item) => item.key === key);
      if (target) {
        target[dataIndex] = value;
        this.dataSource = dataSource;
      }
    },
    onDelete(key) {
      console.log(key);
      axios_service.delete_with_params(this.$store, "/deal/delete?dealId=" + key, null).then((res) => {
        console.log(res);
        let _this = this;
        _this.loading = true;
        _this.$message.success("已取消订单");
        _this.queryTable();
      });
    },
    addItem() {
      console.log("show");
      this.visible = true;
    },
    commentModal(record) {
      console.log("record is ", record);
      this.updateRecorder = record;
      this.updatevisible = true;
    },
    confirmModal(record) {
      this.updateRecorder = record;
      this.visible = true;
    },
    handleCancel() {
      this.visible = false;
    },
    updateCancel() {
      this.updatevisible = false;
    },
    updateCreate() {
      const form = this.$refs.updateForm.form;
      form.validateFields((err, values) => {
        if (err) {
          return;
        }
        let params = {
          dealId: this.updateRecorder.dealId,
          content: values.content,
        };
        axios_service.post_with_params(this.$store, "/dealcomment/insert?", params).then((res) => {
          console.log(res);
          let _this = this;
          _this.loading = true;
          this.handleOk(2);
          _this.queryTable();
        });
        form.resetFields();
        this.updatevisible = false;
      });
    },
    handleOk(status) {
      axios_service.put_with_params(this.$store, "/deal/update?", {
        dealId: this.updateRecorder.dealId,
        "status": status,
        "seller": this.updateRecorder.seller,
        "merchandiseId": this.updateRecorder.merchandiseId,
      }).then((res) => {
        console.log(res);
        let _this = this;
        _this.loading = true;
        _this.queryTable();
        _this.visible = false;
      });
    },
    queryTable() {
      let _this = this;
      _this.loading = true;
      axios_service.get_with_params(this.$store, "/deal/selectByBuyer?buyer=" + this.$store.state.user.userID, null).then((res) => {
        //将返回的数据存入页面中声明的data中
        console.log(res);
        _this.data = res;
        this.formData();
        _this.loading = false;
      })
          .catch(function (error) {
            console.log("error case!");
            _this.$notification.open({
              message: "无法获取表格数据",
              icon: <a-icon type="warning" style="color: #ff1820"/>,
              description:
                  "请检查后端是否正常运行，是否允许跨域；或修改main.js中的axios全局参数，以匹配后端Api",
              duration: 10,
            });
          });
    },
  },
  created() {
    this.queryTable();
    console.log(this.data);
  },
};
</script>
<style>
.editable-cell {
  position: relative;
}

.editable-cell-input-wrapper,
.editable-cell-text-wrapper {
  padding-right: 24px;
}

.editable-cell-text-wrapper {
  padding: 5px 24px 5px 5px;
}

.editable-cell-icon,
.editable-cell-icon-check {
  position: absolute;
  right: 0;
  width: 20px;
  cursor: pointer;
}

.editable-cell-icon {
  line-height: 18px;
  display: none;
}

.editable-cell-icon-check {
  line-height: 28px;
}

.editable-cell:hover .editable-cell-icon {
  display: inline-block;
}

.editable-cell-icon:hover,
.editable-cell-icon-check:hover {
  color: #108ee9;
}

.editable-add-btn {
  margin-bottom: 8px;
}

.editable-row-operations a {
  margin-right: 8px;
}

.flextitle {
  margin: 0 0 20px 0;
  width: 100%;
  display: flex;
  justify-content: space-between;
}
</style>
