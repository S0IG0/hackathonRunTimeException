export interface Comment {
    id: number,
    text: string,
    commentDate: string,
    "commentAuthor": {
        id: number
        name: string
        surname: string
    }
}

interface Props {
    comment: Comment
}

export const CommentCard = ({comment}: Props) => {
    return (
        <div className="card mb-3" key={comment.id}>
            <div className="card-header bg-transparent">
                <div>{comment.commentAuthor.name} {comment.commentAuthor.surname}</div>
                {comment.commentDate}
            </div>
            <div className="card-body">
                <p className="card-text">{comment.text}</p>
            </div>
        </div>
    );
}