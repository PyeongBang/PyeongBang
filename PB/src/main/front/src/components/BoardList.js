import React from 'react';

function BoardList({ boardId, boardTitle, boardContent, boardWriter, boardDate}) {

    return (
        <tr>
            <td align={"center"}>{boardId}</td>
            <td align={"center"}>{boardTitle}</td>
            <td align={"center"}>{boardContent}</td>
            <td align={"center"}>{boardWriter}</td>
            <td align={"center"}>{boardDate}</td>
        </tr>
    )
}

export default BoardList;