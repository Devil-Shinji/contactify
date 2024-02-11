import axios, {AxiosBasicCredentials, AxiosInstance, AxiosRequestConfig, AxiosResponse} from 'axios';
import {IHandleRequestOptions} from "../options/models";
import {IUserLogin} from "../users/models";

class APIClient {
    private axiosInstance: AxiosInstance;
    private adminUser: IUserLogin = {
        username: process.env.REACT_APP_BACKEND_API_USERNAME || 'dummy',
        password: process.env.REACT_APP_BACKEND_API_PASSWORD || 'dummy'
    };

    constructor() {
        this.axiosInstance = axios.create({baseURL: process.env.REACT_APP_BACKEND_API_URL || 'dummy'});
    }

    private handleRequest(options: IHandleRequestOptions): Promise<AxiosResponse> {
        const requestOptions: AxiosRequestConfig = {
            method: options.method,
            url: options.endpoint,
            data: options.data,
            auth: options.auth
        };

        return this.axiosInstance.request(requestOptions);
    }

    public async getAllRequest(endpoint: string, auth: AxiosBasicCredentials): Promise<AxiosResponse> {
        return this.handleRequest({method: "GET", endpoint: endpoint, auth: auth})
    }

    public async getSingleRequest(endpoint: string, id: number, auth: AxiosBasicCredentials): Promise<AxiosResponse> {
        return this.handleRequest({method: "GET", endpoint: endpoint + '/' + id, auth: auth})
    }

    public async getSingleByUsernameRequest(endpoint: string, username: string, auth: AxiosBasicCredentials): Promise<AxiosResponse> {
        return this.handleRequest({method: "GET", endpoint: endpoint + '/byName/' + username, auth: auth})
    }

    public async postRequest(endpoint: string, data: any, auth: AxiosBasicCredentials): Promise<AxiosResponse> {
        return this.handleRequest({method: "POST", endpoint: endpoint, data: data, auth: auth})
    }

    public async putRequest(endpoint: string, id: number, data: any, auth: AxiosBasicCredentials): Promise<AxiosResponse> {
        return this.handleRequest({method: "PUT", endpoint: endpoint + '/' + id, data: data, auth: auth})
    }

    public async deleteRequest(endpoint: string, id: number, auth: AxiosBasicCredentials): Promise<AxiosResponse> {
        return this.handleRequest({method: "DELETE", endpoint: endpoint + '/' + id, auth: auth})
    }

    public async testRequest(auth: AxiosBasicCredentials): Promise<AxiosResponse> {
        return this.handleRequest({method: "GET", endpoint: "ping", auth: auth})
    }
}

export const apiClient = new APIClient();