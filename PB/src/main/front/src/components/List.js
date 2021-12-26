import React from "react";
import 'simplebar';
import 'simplebar/dist/simplebar.css';
import SimpleBar from "simplebar";
import './List.css';
import ListElements from './ListElements';

const List = () =>{
    //const test = new SimpleBar(document.getElementById('myElement'));

    return (
    <div className={"styled_Scrollbar kYjKfC"}>
        <div className={"simplebar-wrapper"}>
            <div className={"simplebar-height-auto-observer-wrapper"}>
                <div className={"simplebar-height-auto-observer"}></div>
            </div>
            <div className={"simplebar-mask"}>
                <div className={"simplebar-offset"}>
                    <div className={"simplebar-content-wrapper"}>
                        <div className={"simplebar-content"}>
                            <ul className={"itemList bQZezw"}>
                                <ListElements
                                    key={1}
                                    MonthlyPrice={20}
                                    deposit={150}
                                    roomtype={"원룸"}
                                    basicInfo={"3층, 19.8m², 관리비 3만"}
                                    simpleIntro={"대구대정문 도시가스설치 가성비짱 원룸..."}/>
                                <ListElements
                                    key={1}
                                    MonthlyPrice={20}
                                    deposit={150}
                                    roomtype={"원룸"}
                                    basicInfo={"3층, 19.8m², 관리비 3만"}
                                    simpleIntro={"대구대정문 도시가스설치 가성비짱 원룸..."}/>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div className={"simplebar-placeholder"}></div>
        </div>
        <div className={"simplebar-horizontal"}></div>
        <div className={"simplebar-vertical"}></div>
    </div>
    )
}

export default List;