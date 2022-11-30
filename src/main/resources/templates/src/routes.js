import HelloWorld from './components/HelloWorld.vue'
import Login from './components/login'
import Product from "./components/Product";
import MarketBase from "@/components/MarketBase";
import MarketBaseList from "@/components/MarketBaseList";
export default [
    {path:'/',component:HelloWorld},
    {path:'/login',component:Login},
    {path:'/product',component:Product},
    {path:'/market-base',component:MarketBase},
    {path:'/market-base/list',component:MarketBaseList},
]