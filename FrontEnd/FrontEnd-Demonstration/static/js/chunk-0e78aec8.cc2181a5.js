(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0e78aec8"],{"1da1":function(t,e,r){"use strict";r.d(e,"a",(function(){return o}));r("d3b7");function n(t,e,r,n,o,i,a){try{var c=t[i](a),s=c.value}catch(u){return void r(u)}c.done?e(s):Promise.resolve(s).then(n,o)}function o(t){return function(){var e=this,r=arguments;return new Promise((function(o,i){var a=t.apply(e,r);function c(t){n(a,o,i,c,s,"next",t)}function s(t){n(a,o,i,c,s,"throw",t)}c(void 0)}))}}},"5ea8":function(t,e,r){"use strict";var n=r("882d"),o=r.n(n);o.a},"882d":function(t,e,r){},"96cf":function(t,e,r){var n=function(t){"use strict";var e,r=Object.prototype,n=r.hasOwnProperty,o="function"===typeof Symbol?Symbol:{},i=o.iterator||"@@iterator",a=o.asyncIterator||"@@asyncIterator",c=o.toStringTag||"@@toStringTag";function s(t,e,r){return Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}),t[e]}try{s({},"")}catch(P){s=function(t,e,r){return t[e]=r}}function u(t,e,r,n){var o=e&&e.prototype instanceof v?e:v,i=Object.create(o.prototype),a=new $(n||[]);return i._invoke=k(t,r,a),i}function l(t,e,r){try{return{type:"normal",arg:t.call(e,r)}}catch(P){return{type:"throw",arg:P}}}t.wrap=u;var f="suspendedStart",h="suspendedYield",p="executing",d="completed",m={};function v(){}function g(){}function y(){}var w={};w[i]=function(){return this};var b=Object.getPrototypeOf,_=b&&b(b(F([])));_&&_!==r&&n.call(_,i)&&(w=_);var x=y.prototype=v.prototype=Object.create(w);function L(t){["next","throw","return"].forEach((function(e){s(t,e,(function(t){return this._invoke(e,t)}))}))}function E(t,e){function r(o,i,a,c){var s=l(t[o],t,i);if("throw"!==s.type){var u=s.arg,f=u.value;return f&&"object"===typeof f&&n.call(f,"__await")?e.resolve(f.__await).then((function(t){r("next",t,a,c)}),(function(t){r("throw",t,a,c)})):e.resolve(f).then((function(t){u.value=t,a(u)}),(function(t){return r("throw",t,a,c)}))}c(s.arg)}var o;function i(t,n){function i(){return new e((function(e,o){r(t,n,e,o)}))}return o=o?o.then(i,i):i()}this._invoke=i}function k(t,e,r){var n=f;return function(o,i){if(n===p)throw new Error("Generator is already running");if(n===d){if("throw"===o)throw i;return I()}r.method=o,r.arg=i;while(1){var a=r.delegate;if(a){var c=C(a,r);if(c){if(c===m)continue;return c}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if(n===f)throw n=d,r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n=p;var s=l(t,e,r);if("normal"===s.type){if(n=r.done?d:h,s.arg===m)continue;return{value:s.arg,done:r.done}}"throw"===s.type&&(n=d,r.method="throw",r.arg=s.arg)}}}function C(t,r){var n=t.iterator[r.method];if(n===e){if(r.delegate=null,"throw"===r.method){if(t.iterator["return"]&&(r.method="return",r.arg=e,C(t,r),"throw"===r.method))return m;r.method="throw",r.arg=new TypeError("The iterator does not provide a 'throw' method")}return m}var o=l(n,t.iterator,r.arg);if("throw"===o.type)return r.method="throw",r.arg=o.arg,r.delegate=null,m;var i=o.arg;return i?i.done?(r[t.resultName]=i.value,r.next=t.nextLoc,"return"!==r.method&&(r.method="next",r.arg=e),r.delegate=null,m):i:(r.method="throw",r.arg=new TypeError("iterator result is not an object"),r.delegate=null,m)}function O(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function j(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function $(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(O,this),this.reset(!0)}function F(t){if(t){var r=t[i];if(r)return r.call(t);if("function"===typeof t.next)return t;if(!isNaN(t.length)){var o=-1,a=function r(){while(++o<t.length)if(n.call(t,o))return r.value=t[o],r.done=!1,r;return r.value=e,r.done=!0,r};return a.next=a}}return{next:I}}function I(){return{value:e,done:!0}}return g.prototype=x.constructor=y,y.constructor=g,g.displayName=s(y,c,"GeneratorFunction"),t.isGeneratorFunction=function(t){var e="function"===typeof t&&t.constructor;return!!e&&(e===g||"GeneratorFunction"===(e.displayName||e.name))},t.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,y):(t.__proto__=y,s(t,c,"GeneratorFunction")),t.prototype=Object.create(x),t},t.awrap=function(t){return{__await:t}},L(E.prototype),E.prototype[a]=function(){return this},t.AsyncIterator=E,t.async=function(e,r,n,o,i){void 0===i&&(i=Promise);var a=new E(u(e,r,n,o),i);return t.isGeneratorFunction(r)?a:a.next().then((function(t){return t.done?t.value:a.next()}))},L(x),s(x,c,"Generator"),x[i]=function(){return this},x.toString=function(){return"[object Generator]"},t.keys=function(t){var e=[];for(var r in t)e.push(r);return e.reverse(),function r(){while(e.length){var n=e.pop();if(n in t)return r.value=n,r.done=!1,r}return r.done=!0,r}},t.values=F,$.prototype={constructor:$,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=e,this.done=!1,this.delegate=null,this.method="next",this.arg=e,this.tryEntries.forEach(j),!t)for(var r in this)"t"===r.charAt(0)&&n.call(this,r)&&!isNaN(+r.slice(1))&&(this[r]=e)},stop:function(){this.done=!0;var t=this.tryEntries[0],e=t.completion;if("throw"===e.type)throw e.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var r=this;function o(n,o){return c.type="throw",c.arg=t,r.next=n,o&&(r.method="next",r.arg=e),!!o}for(var i=this.tryEntries.length-1;i>=0;--i){var a=this.tryEntries[i],c=a.completion;if("root"===a.tryLoc)return o("end");if(a.tryLoc<=this.prev){var s=n.call(a,"catchLoc"),u=n.call(a,"finallyLoc");if(s&&u){if(this.prev<a.catchLoc)return o(a.catchLoc,!0);if(this.prev<a.finallyLoc)return o(a.finallyLoc)}else if(s){if(this.prev<a.catchLoc)return o(a.catchLoc,!0)}else{if(!u)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return o(a.finallyLoc)}}}},abrupt:function(t,e){for(var r=this.tryEntries.length-1;r>=0;--r){var o=this.tryEntries[r];if(o.tryLoc<=this.prev&&n.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===t||"continue"===t)&&i.tryLoc<=e&&e<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=t,a.arg=e,i?(this.method="next",this.next=i.finallyLoc,m):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),m},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.finallyLoc===t)return this.complete(r.completion,r.afterLoc),j(r),m}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.tryLoc===t){var n=r.completion;if("throw"===n.type){var o=n.arg;j(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(t,r,n){return this.delegate={iterator:F(t),resultName:r,nextLoc:n},"next"===this.method&&(this.arg=e),m}},t}(t.exports);try{regeneratorRuntime=n}catch(o){Function("r","regeneratorRuntime = r")(n)}},"9d5a":function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("MyHeader",{attrs:{head_index:"7"}}),t._m(0),r("a-form-model",{attrs:{model:t.form,"label-col":t.labelCol,"wrapper-col":t.wrapperCol}},[r("a-form-model-item",{attrs:{label:"手办名称"}},[r("a-select",{attrs:{placeholder:"please select your zone"},on:{change:t.selectChange}},t._l(t.figureList,(function(e){return r("a-select-option",{key:e.figureId,attrs:{value:e.figureId}},[t._v(" "+t._s(e.figureName)+" ")])})),1)],1),r("a-form-model-item",{attrs:{"has-feedback":"",label:"价格",prop:"pass"}},[r("a-input",{attrs:{prefix:"￥",type:"number",autocomplete:"off"},model:{value:t.form.price,callback:function(e){t.$set(t.form,"price",e)},expression:"form.price"}})],1),r("a-form-model-item",{attrs:{label:"状态"}},[r("a-radio-group",{attrs:{"button-style":"solid"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},[r("a-radio-button",{attrs:{value:"1"}},[t._v(" 二手 ")]),r("a-radio-button",{attrs:{value:"0"}},[t._v(" 全新 ")])],1)],1),r("a-form-model-item",{attrs:{label:"照片"}},[r("a-upload",{staticClass:"form-uploader",attrs:{name:"uploadImg","list-type":"picture-card","file-list":t.fileList,"before-upload":t.beforeUpload},on:{change:t.handleChange}},[t.fileList.length<9?r("div",[r("a-icon",{attrs:{type:"plus"}}),r("div",{staticClass:"ant-upload-text"},[t._v(" Upload ")])],1):t._e()]),r("a-modal",{attrs:{visible:t.previewVisible,footer:null},on:{cancel:t.handleCancel}},[r("img",{staticStyle:{width:"100%"},attrs:{alt:"example",src:t.previewImage}})])],1),r("a-form-model-item",{attrs:{"wrapper-col":{span:14,offset:4}}},[r("a-button",{attrs:{type:"primary",shape:"round"},on:{click:t.onSubmit}},[t._v(" 发布 ")]),r("a-button",{staticStyle:{"margin-left":"10px"},attrs:{shape:"round"},on:{click:t.onCancel}},[t._v(" 返回 ")])],1)],1)],1)},o=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"img-responsive"},[r("h1",{staticClass:"h1"},[t._v("发布新商品")])])}],i=(r("d3b7"),r("25f0"),r("96cf"),r("1da1")),a=r("0c6d");function c(t){return new Promise((function(e,r){var n=new FileReader;n.readAsDataURL(t),n.onload=function(){return e(n.result)},n.onerror=function(t){return r(t)}}))}var s={components:{MyHeader:function(){return Promise.resolve().then(r.bind(null,"b8a9"))}},data:function(){return{previewVisible:!1,previewImage:"",labelCol:{span:4},wrapperCol:{span:8},form:{price:"",type:"1",selectFigure:""},fileList:[],figureList:[]}},beforeCreate:function(){this.form=this.$form.createForm(this,{name:"uploadPicture"})},methods:{handleCancel:function(){this.previewVisible=!1},handlePreview:function(t){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function r(){return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:if(t.url||t.preview){r.next=4;break}return r.next=3,c(t.originFileObj);case 3:t.preview=r.sent;case 4:e.previewImage=t.url||t.preview,e.previewVisible=!0;case 6:case"end":return r.stop()}}),r)})))()},beforeUpload:function(t,e){var r=this;return c(t,(function(t){r.imageUrl=t})),!1},handleChange:function(t){var e=t.fileList;this.fileList=e},onSubmit:function(){var t=this,e=this;console.log("submit!",this.form);var r={price:this.form.price,status:0,type:this.form.type};a["a"].post_with_params(this.$store,"merchandise/insert?",r).then((function(r){var n=r.detail.merchandiseId.toString(),o={merchandiseId:n,figureId:e.form.selectFigure};a["a"].post_with_params(t.$store,"sale/insert?",o).then((function(){e.axios_upload(0,n,e.fileList).then((function(){e.fileList=[],t.$message.success("发布成功"),t.$router.back()})).catch((function(e){console.log(e),t.$message.error("发布失败")}))})).catch((function(e){console.log(e),t.$message.error("发布失败")}))})).catch((function(e){console.log(e),t.$message.error("发布失败")}))},axios_upload:function(t,e,r){if(t!=r.length){var n=this;return a["a"].post_with_file(this.$store,"merchandiseimg/insert?merchandiseId="+e,null,r[t].originFileObj).then((function(o){return n.axios_upload(t+1,e,r)}))}},onCancel:function(){this.$router.back()},selectChange:function(t){this.form.selectFigure=t},queryTable:function(){console.log("try figure");var t=this;a["a"].get_with_params(this.$store,"/figure/selectAll",null).then((function(e){t.figureList=e})).catch((function(t){console.log("figure fail")}))}},created:function(){this.queryTable()}},u=s,l=(r("5ea8"),r("2877")),f=Object(l["a"])(u,n,o,!1,null,"f4ce8dbe",null);e["default"]=f.exports}}]);
//# sourceMappingURL=chunk-0e78aec8.cc2181a5.js.map