(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-9e4c0318"],{"1e2f":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"blackboards"},[a("div",{staticClass:"header"},[a("div",{staticClass:"title"},[t._v("今日推荐")]),a("a",{staticClass:"more",attrs:{target:"_blank"},on:{click:t.routeToShop}},[a("a-icon",{staticClass:"be-icon",attrs:{type:"ellipsis"}}),t._v(" 更多 ")],1)]),t._l(t.blackboards,(function(t,e){return a("input",{key:e,staticClass:"hidden-input",attrs:{type:"radio",name:"blackboard",id:"blackboard"+e,"data-index":e},domProps:{checked:0===e}})})),a("div",{staticClass:"blackboard-cards"},t._l(t.blackboards,(function(e,n){return a("a",{key:n,staticClass:"blackboard-card",attrs:{target:"_blank",href:e.url,title:e.title}},[a("img",{staticStyle:{width:"100%","max-width":"100%",height:"auto"},attrs:{src:e.imageUrl}}),a("div",{staticClass:"title"},[t._v(t._s(e.title))])])})),0),a("div",{staticClass:"jump-dots"},t._l(t.blackboards,(function(t,e){return a("label",{key:e,attrs:{for:"blackboard"+e}},[a("div",{staticClass:"jump-dot"})])})),0)],2)},i=[],l=(a("d3b7"),a("96cf"),a("1da1")),r=a("0c6d"),s={components:{matIcon:function(){return a.e("chunk-1d6133d6").then(a.bind(null,"eb53"))},"dpi-img":function(){return a.e("chunk-f9f01c62").then(a.bind(null,"c190"))}},data:function(){return{val:[!1,!0,!1],blackboards:[{title:"剧场版动画《刀剑神域 进击篇》即将在2021年上映",url:"http://localhost:2333/ImgStore/LIGHT%20Insanae.jpg",imageUrl:this.$global.staticURL+"亚斯娜1.jpg"},{title:"剧场版动画《刀剑神域 进击篇》即将在2021年上映",url:this.$global.wikiURL+"亚斯娜2.jpg",imageUrl:"http://localhost:2333/ImgStore/LIGHT%20Insanae.jpg"},{title:"剧场版动画《刀剑神域 进击篇》即将在2021年上映",url:this.$global.staticURL+"亚斯娜3.jpg",imageUrl:this.$global.staticURL+"亚斯娜3.jpg"}],interval:0,inputIndex:0}},created:function(){r["a"].get("roleimg/selectAll",null).then((function(t){console.log(t)}))},methods:{routeToShop:function(){this.$router.push("/market")},updateIndex:function(){}},watch:{$route:function(t,e){clearInterval(this.interval)}},mounted:function(){var t=this;return Object(l["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:t.interval=setInterval((function(){for(var t=document.getElementsByClassName("hidden-input"),e=0,a=0;a<t.length;a++)if(!0===t[a].checked){t[a].checked=!1,e=(a+1)%t.length,t[e].checked=!0;break}}),5e3),window.onresize=function(){clearInterval(this.interval)};case 2:case"end":return e.stop()}}),e)})))()}},c=s,o=(a("d02f"),a("2877")),u=Object(o["a"])(c,n,i,!1,null,null,null);e["default"]=u.exports},"42a6":function(t,e,a){},d02f:function(t,e,a){"use strict";var n=a("42a6"),i=a.n(n);i.a}}]);
//# sourceMappingURL=chunk-9e4c0318.d62545c8.js.map