import {Category, EventDto} from "@api/type.ts";

interface Props {
    event: EventDto
    handleShowOnMap: (event: EventDto) => void
}

export const styles: { [key in Category]: string } = {
    [Category.Water]: "badge bg-primary-subtle text-primary-emphasis rounded-pill",
    [Category.Light]: "badge bg-warning-subtle text-warning-emphasis rounded-pill",
    [Category.Gas]: "badge bg-success-subtle text-success-emphasis rounded-pill",
    [Category.Heating]: "badge bg-danger-subtle text-danger-emphasis rounded-pill",
    [Category.Street]: "badge bg-info-subtle text-info-emphasis rounded-pill",
    [Category.Other]: "badge bg-secondary-subtle text-secondary-emphasis rounded-pill",
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
                        {event.category && (
                            <li className="list-group-item">
                                <div className={styles[event.category]}>
                                    {event.category}
                                </div>
                            </li>
                        )}
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