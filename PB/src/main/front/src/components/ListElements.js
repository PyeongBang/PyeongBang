import React from 'react';
import r1 from'./sampleImage/room1.jpg';
import './sampleImage/room2.jpg';
import './sampleImage/room3.jpg';
import './sampleImage/room4.jpg';
import './sampleImage/room5.jpg';
import './sampleImage/room6.jpg';
import './sampleImage/room7.jpg';
import './sampleImage/room8.jpg';
import './sampleImage/room9.jpg';
import './sampleImage/room10.jpg';
import './ListElements.css';

function ListElements({key, MonthlyPrice, deposit, roomType, basicInfo, simpleIntro}){
    return(
        <li className={"item-card gcRKRU"} key={key}>
            <div className={"basicCard cgePTp"}>
                <div className={"ImgWrap gPEthp"}>
                    <div className={"ImgAmi gMnRzx"}>
                        <img src={r1}
                             width={"60"}
                             height={"60"}
                             draggable={"false"}
                             loading={"lazy"}
                        />
                    </div>
                </div>
                <div className={"content iamnls"}>
                    <div className={"infoWrap fOVNCS"}>
                        <h1 className={"price kPmScS"}>월세 {MonthlyPrice+"/"+deposit}</h1>
                        <p className={"roomType fGfKPR"}>{roomType}</p>
                        <p className={"basicInfo fYtEsj"}>{basicInfo}</p>
                        <p className={"otherInfo fYtEsj"}>{simpleIntro}</p>
                    </div>
                </div>
            </div>
        </li>
    )
}
export default ListElements;