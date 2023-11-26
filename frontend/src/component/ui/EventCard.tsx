import {EventDto} from "@api/type.ts";

interface Props {
    event: EventDto
    handleShowOnMap: (event: EventDto) => void
}

export const EventCard = ({event, handleShowOnMap}: Props) => {
    return (
        <div className="col-auto">
            <div className="mb-4">
                <div className="card" style={{width: "18em"}}>
                    <img src={event.picture} className="card-img-top" alt="Тут должно быть изображение"/>
                    <div className="card-body">
                        <h5 className="card-title">{event.title}</h5>
                        <h6 className="card-subtitle mb-2 text-body-secondary">{event.author?.name}</h6>
                    </div>
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item">{event.category}</li>
                        <li className="list-group-item">{event.location?.address}</li>
                    </ul>
                    <div className="card-body">
                        <a
                            href="#"
                            className="card-link"
                            onClick={() => handleShowOnMap(event)}
                        >
                            Показать на карте
                        </a>
                    </div>
                </div>
            </div>
        </div>
    );
}