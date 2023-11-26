import {makeAutoObservable} from "mobx";

export enum Role {
    PUBLIC,
    PUBLIC_HIDE,
    PUBLIC_ONLY_NOT_AUTH,
    USER,
    ADMIN,
    ORGANIZATION,
}

export enum OtherService {
    YANDEX,
    VK,
    GOSUSLUGI,

}

class Store {
    constructor() {
        makeAutoObservable(this);
    }

    // TODO added new fields for (user, organization and more ...)

    isAuth: boolean = true;
    currentRole: Role = Role.USER;

    setIsAuth(isAuth: boolean) {
        this.isAuth = isAuth;
    }

    setCurrentRole(currentRole: Role) {
        this.currentRole = currentRole;
    }

    // TODO create async request
}

export const store = new Store();


