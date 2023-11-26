import {Category, EventDto, Status} from "@api/type.ts";
import {YMaps, Map as YandexMap, Placemark} from "@pbe/react-yandex-maps";
import {useRef, useState} from "react";
import {GridListView} from "@ui/GridListView.tsx";
import {EventCard} from "@ui/EventCard.tsx";
// TODO creat request from real server
const data: EventDto[] = [
    {
        "id": 1,
        "title": "Ремонт дороги",
        "text": "Ремонт продлится с 01.01.2023 до 02.01.2023",
        "status": Status.Published,
        "category": Category.Street,
        "author": {
            "id": 7771272,
            "name": "ЖЭК"
        },
        "location": {
            "address": "Ул. Колотушкина, д. Пушкина",
            "lat": 55.754167,
            "lon": 37.62,
        },
        "date": "2024-12-31 15:10:05",
        "picture": "https://www.gtrk-vyatka.ru/uploads/posts/2021-07/1626529063_86.jpg"
    },
    {
        "id": 2,
        "title": "Ремонт дороги 2",
        "text": "Ремонт продлится с 03.02.2023 до 04.02.2023",
        "status": Status.Published,
        "category": Category.Street,
        "author": {
            "id": 7771273,
            "name": "Газпром"
        },
        "location": {
            "address": "Ул. Строительная, д. Иванова",
            "lat": 55.743056,
            "lon": 37.61
        },
        "date": "2024-12-30 14:20:00",
        "picture": "https://privadmin.ru/assets/uploads/2023-02-09/2023-02-09_14-36-54_3.jpg"
    },
    {
        "id": 3,
        "title": "Ремонт канализации",
        "text": "Ремонт продлится с 05.03.2023 до 06.03.2023",
        "status": Status.Published,
        "category": Category.Water,
        "author": {
            "id": 7771274,
            "name": "Водоканал"
        },
        "location": {
            "address": "Ул. Трубная, д. Сидорова",
            "lat": 55.748889,
            "lon": 37.60
        },
        "date": "2024-12-29 13:30:15",
        "picture": "https://septikmaster.ru/wp-content/uploads/remont-kanalizaczii-v-mnogokvartirnom-dome.jpeg"
    },
    {
        "id": 4,
        "title": "Электромонтажные работы",
        "text": "Работы проводятся с 07.04.2023 до 08.04.2023",
        "status": Status.Published,
        "category": Category.Light,
        "author": {
            "id": 7771275,
            "name": "Электросети"
        },
        "location": {
            "address": "Ул. Проводникова, д. Вольтова",
            "lat": 55.751944,
            "lon": 37.59
        },
        "date": "2024-12-28 12:40:25",
        "picture": "https://odinenergo.ru/wp-content/uploads/2016/02/electromontazh.jpg"
    },
    {
        "id": 5,
        "title": "Строительство парка",
        "text": "Строительство будет завершено с 09.05.2023 до 10.05.2023",
        "status": Status.Published,
        "category": Category.Street,
        "author": {
            "id": 7771276,
            "name": "Городской ландшафт"
        },
        "location": {
            "address": "Ул. Парковая, д. Цветочная",
            "lat": 55.760278,
            "lon": 37.58
        },
        "date": "2024-12-27 11:50:35",
        "picture": "https://did-you-know.ru/wp-content/uploads/2022/08/7834877348783467693834.jpg"
    }
]


export const EventsPage = () => {

    const [selectedEvent, setSelectedEvent] = useState<EventDto | null>(null);
    // @ts-ignore
    const mapRef = useRef<YandexMap | undefined>(undefined);

    const handleShowOnMap = (event: EventDto) => {
        setSelectedEvent(event);
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
                                    preset: selectedEvent && selectedEvent.id === event.id ? "islands#redCircleDotIcon" : undefined,
                                }}
                            />
                        ))}
                    </YandexMap>
                </div>
            </YMaps>

            <GridListView
                array={data.map(event =>
                    <EventCard key={event.id} event={event} handleShowOnMap={handleShowOnMap}/>
                )}
            />
        </>
    );
}