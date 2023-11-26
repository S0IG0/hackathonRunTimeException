import {Link} from "react-router-dom";
import {EventDto, NewsDto} from "@api/type.ts";
import {styles} from "@ui/EventCard.tsx";

interface Props {
    news: NewsDto
    handleShowOnMap: (event: EventDto) => void
}

export const NewsCard = ({news, handleShowOnMap}: Props) => {
    return (
        <div className="col-auto">
            <div className="mb-4">
                <div className="card" style={{width: "18em"}}>
                    <img src={news.picture} className="card-img-top" alt="Тут должно быть изображение"/>
                    <div className="card-body">
                        <h5 className="card-title">{news.title}</h5>
                        <h6 className="card-subtitle mb-2 text-body-secondary">{news.author?.name}</h6>
                    </div>
                    <ul className="list-group list-group-flush">
                        {news.category && (
                            <li className="list-group-item">
                                <div className={styles[news.category]}>
                                    {news.category}
                                </div>
                            </li>
                        )}
                        <li className="list-group-item">{news.location?.address}</li>
                    </ul>
                    <div className="card-body">
                        <a
                            href="#"
                            className="card-link"
                            onClick={() => handleShowOnMap(news)}
                        >
                            Показать на карте
                        </a>
                        <Link
                            to={`/news/${news.id}`}
                            className="card-link"
                        >
                            подробнее
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
}