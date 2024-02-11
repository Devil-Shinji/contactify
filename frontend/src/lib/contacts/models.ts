import {IUserList} from "../users/models";

export interface IContactBase {
    realName: string;
    codeName: string;
    phoneNumber: string;
}

export interface IContactList extends IContactBase {
    id: number;
}

export interface IContactEdit extends IContactBase {
    userId?: number;
}

export interface IContactDetail extends IContactList {
    user: IUserList
}