import {SurveyDto} from "@api/type.ts";
import {store} from "@store/store.ts";

interface Props {
    survey: SurveyDto
}

export const Survey = ({survey}: Props) => {
    const count = survey.options?.map(item => item.votes).reduce((a, b) => a + b, 0);
    const isAuth = store.isAuth;

    // TODO make logic add new vote and send vote in backend

    return (
        <div className="card mb-4">
            <h5 className="card-header">Голосование</h5>
            <div className="card-body">
                <h5 className="card-title">{survey.description}</h5>
                <p className="card-text">Всего проголосовало {count}</p>
                <div className="list-group mb-2">
                    {survey.options?.map(option => (
                        <div className="list-group" key={option.id}>
                            <label className="list-group-item d-flex gap-2 mb-2">
                                <input className="form-check-input flex-shrink-0"
                                       type="radio"
                                       name="listGroupRadios"
                                       id="listGroupRadios1" value=""
                                />
                                <span>
                        {option.text}
                                    <small className="d-block text-body-secondary">
                            Проголосовало {option.votes}
                        </small>
                    </span>
                            </label>
                        </div>
                    ))}
                </div>
                {isAuth && (
                    <div className="btn btn-success">Проголосвать</div>
                )}
            </div>
        </div>
    );
}