import {AxiosBasicCredentials} from "axios";

export interface IHandleRequestOptions {
    method: string;
    endpoint: string;
    data?: any;
    auth?: AxiosBasicCredentials;
}