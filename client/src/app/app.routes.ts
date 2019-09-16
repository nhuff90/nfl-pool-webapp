import {HomeComponent} from "./pages/home/home.component";

export const appRoutes=[
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'others',
        loadChildren:'./pages/others/others.module#OthersModule',
    },
];
