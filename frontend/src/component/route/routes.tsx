import {ReactNode} from "react";
import {HomePage} from "@page/public/HomePage.tsx";
import {Role} from "@src/component/store/store.ts";
import {EventsPage} from "@page/public/EventsPage.tsx";
import {NewsPage} from "@page/public/NewsPage.tsx";
import {ThisNewsPage} from "@page/public/ThisNewsPage.tsx";
import {LoginPage} from "@page/public/LoginPage.tsx";
import {RegisterPage} from "@page/public/RegisterPage.tsx";
import {PersonalAccount as UserPersonalAccount} from "@page/user/PersonalAccount.tsx";

export interface Page {
    name: string | ReactNode
    path: string
    component: ReactNode
    visibly: Role[]
}

export enum NamePages {
    HOME,
    EVENTS,
    NEWS,
    THIS_NEWS,
    LOGIN,
    REGISTER,
    USER_PERSONAL_ACCOUNT
}

export const routes: { [key in NamePages]: Page } = {
    [NamePages.HOME]: {
        name: "Главная",
        path: "/",
        component: <HomePage/>,
        visibly: [Role.PUBLIC,],
    } as Page,
    [NamePages.EVENTS]: {
        name: "События",
        path: "/events",
        component: <EventsPage/>,
        visibly: [Role.PUBLIC,],
    } as Page,
    [NamePages.NEWS]: {
        name: "Новости",
        path: "/news",
        component: <NewsPage/>,
        visibly: [Role.PUBLIC,],
    } as Page,
    [NamePages.THIS_NEWS]: {
        name: "Новость",
        path: "/news/:id",
        component: <ThisNewsPage/>,
        visibly: [Role.PUBLIC_HIDE,],
    } as Page,
    [NamePages.LOGIN]: {
        name: "Вход",
        path: "/login",
        component: <LoginPage/>,
        visibly: [Role.PUBLIC_ONLY_NOT_AUTH, Role.PUBLIC],
    } as Page,
    [NamePages.REGISTER]: {
        name: "Регистрация",
        path: "/register",
        component: <RegisterPage/>,
        visibly: [Role.PUBLIC_ONLY_NOT_AUTH, Role.PUBLIC],
    } as Page,
    [NamePages.USER_PERSONAL_ACCOUNT]: {
        name: <i className="bi bi-person-circle"/>,
        path: "/user-account",
        component: <UserPersonalAccount/>,
        visibly: [Role.USER],
    } as Page,
}


