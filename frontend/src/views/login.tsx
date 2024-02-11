import React, {useState} from 'react';
import {IUserLogin} from "../lib/users/models";
import {apiClient} from "../lib/api/APIClient";

interface LoginFormProps {
    onLogin: (user: IUserLogin) => void
}

function LoginForm({onLogin}: LoginFormProps) {
    const [userLogin, setUserLogin] = useState<IUserLogin>(
        {username: "", password: ""}
    );

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>): void => {
        setUserLogin({ ...userLogin,  [event.target.name]: event.target.value });
    }

    const handleSubmit = async (event: React.FormEvent) => {
        event.preventDefault();

        try {
            await apiClient.testRequest(userLogin)
            onLogin(userLogin);
        } catch (error) {
            console.log("Error", error);
            alert("Login failed!")
        }
    }

    return (
        <div className="App">
            <form onSubmit={handleSubmit}>
                <label>
                    Username:
                    <input
                        type="text"
                        value={userLogin.username}
                        name="username"
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Password:
                    <input
                        type="password"
                        value={userLogin.password}
                        name="password"
                        onChange={handleInputChange}
                    />
                </label>

                <input type="submit" value="Login" />

            </form>
        </div>
    );
}

export default LoginForm;