import {IContactList} from "../contacts/models";

export interface IUserBase {
    firstName: string;
    lastName: string;
    username: string;
    email: string;
}

export interface IUserLogin {
    username: string;
    password: string
}

export interface IUserList extends IUserBase {
    id: number;
}

export interface IUserEdit extends IUserBase {
    password: string;
}

export interface IUserDetail extends IUserList {
    contacts: IContactList[]
}