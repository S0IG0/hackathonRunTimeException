import {FormEvent, useState} from "react";
import {Comment} from "@ui/comment/CommentCard.tsx";

interface Props {
    addComment: (comment: Comment) => void
}

export const SendComment = ({addComment}: Props) => {
    const [text, setText] = useState("")

    function action(event: FormEvent<HTMLFormElement>) {
        event.stopPropagation()
        event.preventDefault()
        // TODO get value about of user from store
        addComment({
            id: new Date().getMilliseconds(),
            text: text,
            // TODO fix date
            commentDate: Date(),
            commentAuthor: {
                id: new Date().getMilliseconds(),
                name: "TODO real name",
                surname: "TODO real surname"
            }
        })
        setText("")
    }

    return (
        <form className="row g-2" onSubmit={action}>
            <div className="col-auto">
                <input
                    type="text"
                    className="form-control"
                    placeholder="Комментарий"
                    value={text}
                    onChange={event => setText(event.target.value)}
                />
            </div>
            <div className="col-auto">
                <button type="submit" className="btn btn-primary mb-3">Отправить</button>
            </div>
        </form>
    );
}