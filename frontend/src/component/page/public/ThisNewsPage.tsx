import {useParams} from "react-router-dom";
import {Category, NewsDto, Status} from "@api/type.ts";
import {NotFoundPage} from "@page/public/NotFoundPage.tsx";
import {CommentsList} from "@ui/comment/CommentsList.tsx";
import {Survey} from "@ui/Survey.tsx";

const data: NewsDto[] = [
    {
        "id": 1,
        "title": "Лед появился",
        "author": {
            "id": 7771272,
            "name": "ЖЭК"
        },
        "location": {
            "address": "Ул. Колотушкина, д. Пушкина",
            "lat": 55.754167,
            "lon": 37.62
        },
        "date": "2024-12-31 15:10:05",
        "picture": "https://avatars.mds.yandex.net/i?id=ab9acf31143b9a9e6012f46cf0b5d6dbf8015382-10303547-images-thumbs&n=13",
        "text": "Скоро уберем",
        "Survey": {
            "id": 1,
            "description": "Стоит ли покупать подержанный гараж?",
            "options": [
                {
                    "id": 1,
                    "text": "Да я люблю гаражи хочу еще один",
                    "votes": 100
                },
                {
                    "id": 2,
                    "text": "Нет я люблю только свой гараж",
                    "votes": 66
                }
            ]
        },
        "status": Status.Published,
        "category": Category.Water,
        "comments": [
            {
                "id": 1,
                "text": "Чибипеля",
                "commentDate": "2024-12-31 15:10:05",
                "commentAuthor": {
                    "id": 3,
                    "name": "Даня",
                    "surname": "Красавчик"
                }
            },
            {
                "id": 2,
                "text": "Чибипеля 2",
                "commentDate": "2024-12-31 15:10:05",
                "commentAuthor": {
                    "id": 3,
                    "name": "Даня",
                    "surname": "Красавчик"
                }
            }
        ]
    }
]


export const ThisNewsPage = () => {
    const {id} = useParams();

    if (isNaN(Number(id))) return <NotFoundPage/>

    // TODO creat request from real server
    const news = data.find(news => news.id === Number(id))

    if (!news) return <NotFoundPage/>


    return (
        <>
            <div className="card mb-3">
                <div className="row g-0">
                    <div className="col-md-4">
                        <img src={news.picture} className="img-fluid rounded-start" alt="..."/>
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            <h5 className="card-title">{news.title}</h5>
                            <h6 className="card-subtitle mb-2 text-body-secondary">{news.author?.name}</h6>
                            <h6 className="card-subtitle mb-2 text-body-secondary">{news.location?.address}</h6>
                            <p className="card-text">{news.text}</p>
                            <p className="card-text"><small className="text-muted">{news.date}</small></p>
                        </div>
                    </div>
                </div>
            </div>

            {news.Survey && <Survey survey={news.Survey}/>}
            {news.comments && <CommentsList comments={news.comments}/>}
        </>
    );
}