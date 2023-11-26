import {UserRegister} from "@page/public/RegisterPage.tsx";
import {useState} from "react";
import {Role, store} from "@store/store.ts";
import {useNavigate} from "react-router-dom";
import {NamePages, routes} from "@route/routes.tsx";

interface UserUpdate extends UserRegister {
}

export const PersonalAccount = () => {
    const navigate = useNavigate();

    // TODO get real fields from backend
    const [user, setUser] = useState<UserUpdate>(
        {
            name: "Лев",
            surname: "Шилов",
            email: "shilovLev@example.ru",
            address: "г. Москва район Саларьево улица Калатушкина дом 19",
            password: ""
        }
    )

    const names: UserUpdate = {
        name: "Имя",
        surname: "Фамилия",
        email: "Электронная почта",
        address: "Адрес",
        password: "Новый пароль"
    }

    const fields: (keyof UserUpdate)[] = Object.keys(user) as (keyof UserUpdate)[];

    // TODO make request to the server witch update user fields
    function updateFields() {

    }

    // TODO make request for logout user and clear token from localstorage
    function logout() {
        store.setIsAuth(false);
        store.setCurrentRole(Role.PUBLIC);
        navigate(routes[NamePages.HOME].path);

    }

    return (
        <>
            <div className="control-panel d-flex justify-content-between mb-4">
                <h4 className="display-7 fw-bold">Личный кабинет</h4>
                <button className="btn btn-outline-danger" onClick={logout}>Выйти <i className="bi bi-door-open"/>
                </button>
            </div>

            {fields.map(key => (
                <div className="modal-body pt-0" key={key}>
                    <div className="form-floating mb-3">
                        <input
                            id={`floating${key}`}
                            className="form-control rounded-3"
                            type={["email", "password"].includes(key) ? key : "text"}
                            value={user[key]}
                            onChange={event => setUser({...user, [key]: event.target.value})}
                        />
                        <label
                            htmlFor={`floating${key}`}
                        >
                            {names[key]}
                        </label>
                    </div>
                </div>
            ))}

            <div className="btn btn-success mb-4" onClick={updateFields}>Обновить данные</div>
        </>
    );
}