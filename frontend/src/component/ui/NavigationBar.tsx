import {NamePages, Page, routes} from "@route/routes.tsx";
import {Link, NavLink, Route, Routes, useLocation} from "react-router-dom";
import {NotFoundPage} from "@page/public/NotFoundPage.tsx";
import {observer} from "mobx-react-lite";
import {Role, store} from "@store/store.ts";

export const NavigationBar = observer(() => {
    const currentRole = store.currentRole;
    const isAuth = store.isAuth;

    const location = useLocation();

    const pages: Page[] = Object.keys(NamePages)
        .filter(key => !isNaN(Number(key)))
        .map(key => routes[Number(key) as NamePages])

    return (
        <div className="container">
            <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <Link to={routes[NamePages.HOME].path}
                      className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none me-2">
                    <i className="bi bi-compass me-2" style={{fontSize: 20}}/>
                    <span className="fs-4">Навигатор чистоты</span>
                </Link>

                <ul className="nav nav-pills">
                    {pages.filter(page => {
                        const value = page.visibly.includes(Role.PUBLIC) || page.visibly.includes(currentRole);
                        if (isAuth) {
                            return !page.visibly.includes(Role.PUBLIC_ONLY_NOT_AUTH) && value;
                        }
                        return value
                    }).map(page => (
                        <li className="nav-item" key={page.path}>
                            <NavLink to={page.path} className="nav-link me-2">{page.name}</NavLink>
                        </li>
                    ))}
                </ul>
            </header>

            <Routes location={location}>
                {pages.filter(page => {
                        const value =
                            page.visibly.includes(Role.PUBLIC) ||
                            page.visibly.includes(Role.PUBLIC_HIDE) ||
                            page.visibly.includes(currentRole)
                        if (isAuth) {
                            return !page.visibly.includes(Role.PUBLIC_ONLY_NOT_AUTH) && value;
                        }
                        return value
                    }
                ).map(page => (
                    <Route
                        path={page.path}
                        element={page.component}
                        key={page.path}
                    >
                    </Route>
                ))}
                <Route path={"*"} element={<NotFoundPage/>}></Route>
            </Routes>

        </div>
    );
});