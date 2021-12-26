import React from 'react';
import Header from '../components/Header';
import './Board.css';
import BoardList from "../components/BoardList";

const Board = () =>{
    const boards = [

        {
            id: 1,
            title: '홈마트 쪽 원룸 승계',
            content: '도로쪽 방 아니고 안쪽이라서 크게 시끄럽지 않아요',
            writer: '익명',
            date: '11/07'
        },
        {
            id: 2,
            title: '상림리 원마트랑 가까운 원룸 승계',
            content: '개인 사정으로 방을 비우게 되었는데, 승계하실 분 구해봐요',
            writer: '익명',
            date: '10/19'
        },
        {
            id: 3,
            title: '막다방 옆에 원룸 승계',
            content: '방을 다 비워 놓아서 언제든 바로 들어오실 수 있어요',
            writer: '익명',
            date: '10/25'
        },
        {
            id: 4,
            title: '미니스톱 골목 안쪽 원룸 승계합니다.',
            content: '취업을 빨리 하게되서 기간이 남았네요. 연락주세요',
            writer: '익명',
            date: '11/03'
        },{
            id: 5,
            title: '내리리 gs쪽 엘리트 원룸 승계합니다',
            content: '서문까지 5분거리에 있는 원룸이고, 취업 때문에 방을 비워서 승계해요~',
            writer: '익명',
            date: '10/13'
        }
    ];

    return(
        <React.Fragment>
            <Header/>
            <div className={"content"}>
                <h1 className={"head"} align={"center"}>승계 게시판</h1>
                <div className={"body"} align={"center"}>
                    <table border={"1"}>
                        <tbody>
                            <tr align={"center"}>
                                <td align={"center"} width={"50"}>번호</td>
                                <td width={"300"}>제목</td>
                                <td width={"600"}>내용</td>
                                <td width={"150"}>작성자</td>
                                <td width={"100"}>날짜</td>
                            </tr>
                            {
                                boards.map(row=>(
                                    <BoardList
                                        key={row.id}
                                        boardId={row.id}
                                        boardTitle={row.title}
                                        boardContent={row.content}
                                        boardWriter={row.writer}
                                        boardDate={row.date}
                                    />
                                ))
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </React.Fragment>
    );
}

export default Board;