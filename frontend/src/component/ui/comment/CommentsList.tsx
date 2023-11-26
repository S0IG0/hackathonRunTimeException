import {Comment, CommentCard} from "@ui/comment/CommentCard.tsx";
import {store} from "@store/store.ts";
import {useState} from "react";
import {SendComment} from "@ui/comment/SendComment.tsx";

interface Props {
    comments: Comment[],
}

export const CommentsList = ({comments}: Props) => {
    const isAuth = store.isAuth;
    const [actualityComments, setActualityComments] = useState(comments)

    function addComment(comment: Comment) {
        setActualityComments([...actualityComments, comment])
    }

    return (
        <>
            {actualityComments.map(comment => (
                <CommentCard comment={comment}/>
            ))}
            {isAuth && <SendComment addComment={addComment}/>}
        </>
    );
}