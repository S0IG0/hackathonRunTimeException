import {Link} from "react-router-dom";
import {observer} from "mobx-react-lite";
import {store} from "@store/store.ts";
import {NamePages, routes} from "@route/routes.tsx";

export const HomePage = observer(() => {
    const isAuth = store.isAuth;

    return (
        <>
            <div className="p-5 mb-4 bg-light rounded-3">
                <div className="container-fluid py-5">
                    <h1 className="display-5 fw-bold">Навигатор чистоты</h1>
                    <p className="col-md-8 fs-4">Наш информационный портал "Навигатор чистоты" позволит улучшить
                        коммуникацию между
                        муниципальными службами и горожанами, обеспечивая быстрый обмен информацией и повышая уровень
                        участия граждан в управлении городом.</p>
                    <Link
                        to={routes[NamePages.REGISTER].path}
                        className={`btn btn-${isAuth ? "success" : "primary"} btn-lg ${isAuth && "disabled"}`}
                        type="button"
                        style={{opacity: 1}}
                    >
                        {isAuth ? "Спасибо что вы с нами!" : "Зарегистрируйтесь и присоединяйся к нам!"}
                    </Link>
                </div>
            </div>
            <div className="row align-items-md-stretch">
                <div className="col-md-6 mb-4">
                    <div className="h-100 p-5 text-white bg-dark rounded-3">
                        <h2>События</h2>
                        <p>Удобный интерфейс для взаимодействия с актуальными событиями. Любой гражданин может получить
                            доступ к ближайшим событиям, просмотреть их в виде отмеченных мест на карте, а также
                            ознакомиться с отдельной карточкой события.</p>
                        <Link to={routes[NamePages.EVENTS].path} className="btn btn-outline-light" type="button">
                            К событиям
                        </Link>
                    </div>
                </div>
                <div className="col-md-6 mb-4">
                    <div className="h-100 p-5 bg-light border rounded-3">
                        <h2>Новости</h2>
                        <p>Помимо этого, наш информационный портал предоставляет уникальную возможность следить за
                            новостями. Теперь вы можете узнавать о новостях в формате удобных карточек, а
                            интерактивная карта позволит вам все наглядно увидеть.</p>
                        <Link to={routes[NamePages.NEWS].path} className="btn btn-outline-secondary" type="button">
                            К новостям
                        </Link>
                    </div>
                </div>
            </div>
        </>
    );
});
