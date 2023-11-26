import {Category, EventDto, NewsDto, Status} from "@api/type.ts";
import {GridListView} from "@ui/GridListView.tsx";
import {useRef, useState} from "react";
import {Map as YandexMap, Placemark, YMaps} from "@pbe/react-yandex-maps";
import {Link} from "react-router-dom";
// TODO creat request from real server
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
        "status": Status.Published,
        "category": Category.Water,
    }
]


export const NewsPage = () => {
    const [selectedNews, setSelectedNews] = useState<EventDto | null>(null);
    // @ts-ignore
    const mapRef = useRef<YandexMap | undefined>(undefined);

    const handleShowOnMap = (event: EventDto) => {
        setSelectedNews(event);
        if (mapRef.current) {
            mapRef.current.panTo([event.location?.lat, event.location?.lon], {flying: true});
        }
    };
    return (
        <>
            <YMaps>
                <div className="mb-4 ">
                    <YandexMap
                        width="100%"
                        height="20em"
                        modules={["control.ZoomControl", "control.FullscreenControl"]}
                        defaultState={{
                            center: [55.75, 37.57],
                            zoom: 13,
                            controls: ["zoomControl", "fullscreenControl"],
                        }}
                        instanceRef={mapRef}
                    >
                        {data.map(event => (
                            <Placemark
                                key={event.id}
                                modules={["geoObject.addon.balloon"]}
                                defaultGeometry={[event.location?.lat, event.location?.lon,]}
                                properties={{
                                    balloonContentHeader: `<img style="width: 18em" src="${event.picture}" alt="Картинка"/>`,
                                    iconCaption: event.title,
                                    balloonContentBody: event.title,
                                    balloonContentFooter: event.text,
                                }}
                                options={{
                                    preset: selectedNews && selectedNews.id === event.id ? "islands#redCircleDotIcon" : undefined,
                                }}
                            />
                        ))}
                    </YandexMap>
                </div>
            </YMaps>
            <GridListView array={data.map(news => (
                <div className="col-auto">
                    <div className="mb-4">
                        <div className="card" style={{width: "18em"}}>
                            <img src={news.picture} className="card-img-top" alt="Тут должно быть изображение"/>
                            <div className="card-body">
                                <h5 className="card-title">{news.title}</h5>
                                <h6 className="card-subtitle mb-2 text-body-secondary">{news.author?.name}</h6>
                            </div>
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">{news.category}</li>
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
            ))}
            />
        </>
    );
}