import {ReactNode} from "react";

interface Props {
    array: ReactNode[]
}

export const GridListView = ({array}: Props) => {
    return (
        <div className="row justify-content-lg-between justify-content-sm-center">
            {array}
        </div>
    );
}
