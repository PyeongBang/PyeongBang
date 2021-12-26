import react from 'react';
import ScrollHorizontal from "react-scroll-horizontal";
import React from "react";
import './Estates.css';
import gwangGaeTo from "./estates/gwangGaeTo.jpg";
import naeRee from "./estates/naeRee.jpg";
import newElim from "./estates/newElim.jpg";
import daeguDae from "./estates/daeguDae.jpg";
import daeguDaeAnsim from "./estates/daeguDaeAnsim.jpg";
import daeHakRo from "./estates/daeHakRo.jpg";
import myeongPoom from "./estates/myeongPoom.jpg";
import miso from "./estates/miso.jpg";
import bangGu from "./estates/bangGu.jpg";
import boriOneRoom from "./estates/boriOneRoom.jpg";
import samSung from "./estates/samSung.jpg";
import sunHwa from "./estates/sunHwa.jpg";
import smile from "./estates/smile.jpg";
import ace from "./estates/ace.jpg";
import eunSol from "./estates/eunSol.jpg";
import chamJoeun from "./estates/chamJoeun.jpg";
import posco from "./estates/posco.jpg";
import goldenEgg from "./estates/goldenEgg.jpg";

function Estates(){
    const Estates = [
        {
            url: gwangGaeTo,
            name: "광개토 공인중개사",
            phone: "053-852-8881",
            address: "경북 경산시 진량읍 대구대로 301"
        },{
            url: naeRee,
            name: "내리 공인중개사",
            phone: "053-854-1313",
            address: "경북 경산시 진량읍 진량내리길 5 메이플하우스"
        },{
            url: newElim,
            name: "뉴엘림 부동산 중개사무소",
            phone: "053-852-9393",
            address: "경북 경산시 진량읍 대구대로 266"
        },{
            url: daeguDae,
            name: "대구대 공인중개사 사무소",
            phone: "053-852-8449",
            address: "경북 경산시 진량읍 대구대로 288"
        },{
            url: daeguDaeAnsim,
            name: "대구대 안심 공인중개사",
            phone: "053-853-7700",
            address: "경북 경산시 진량읍 진량내리길 6"
        },{
            url: daeHakRo,
            name: "대학로 부동산",
            phone: "010-7700-8015",
            address: "경북 경산시 진량읍 대구대로 302 개나리"
        },{
            url: myeongPoom,
            name: "대구대 명품 부동산 중개",
            phone: "053-852-9632",
            address: "경북 경산시 진량읍 대구대로 279"
        },{
            url: miso,
            name: "미소 공인중개사",
            phone: "053-852-9632",
            address: "경북 경산시 진량읍 대구대로 279"
        },{
            url: bangGu,
            name: "방구 부동산 중개사무소",
            phone: "010-4828-2555",
            address: "경북 경산시 진량읍 대구대로60길 8"
        },{
            url: boriOneRoom,
            name: "여학생전용 보리원룸",
            phone: "010-4500-1376",
            address: "경북 경산시 진량읍 대구대로 250"
        },{
            url: samSung,
            name: "대구대 삼성 공인중개사",
            phone: "010-7367-8989",
            address: "경북 경산시 진량읍 대구대로58길 1"
        },{
            url: sunHwa,
            name: "선화 공인중개사",
            phone: "053-852-3255",
            address: "경북 경산시 진량읍 진량내리길 23-7"
        },{
            url: smile,
            name: "스마일 부동산",
            phone: "053-856-2401",
            address: "경북 경산시 진량읍 대구대로 296"
        },{
            url: ace,
            name:"에이스 공인중개사 사무소",
            phone:"053-856-0073",
            address:"경북 경산시 진량읍 대구대로13길 4 에이스부동산"
        },{
            url: eunSol,
            name: "은솔 공인중개사 사무소",
            phone: "053-853-5241",
            address: "경북 경산시 진량읍 대구대로 285"
        },{
            url: chamJoeun,
            name: "참좋은 부동산 공인중개사",
            phone: "053-852-8899",
            address: "경북 경산시 진량읍 대구대로 294-1"
        },{
            url: posco,
            name: "포스코 부동산",
            phone: "053-851-7891",
            address: "경북 경산시 진량읍 대구대로 282"
        },{
            url: goldenEgg,
            name: "황금알 부동산",
            phone: "053-857-6764",
            address: "경북 경산시 진량읍 대구대로 295 서울 원룸"
        }
    ];

    return(
        <ul className={"Estates"}>
            {Estates.map((estates, idx)=>{
                return(
                    <li className={"item-card"} key={idx}>
                        <div className={"basicCard"}>
                            <div className={"ImgWrap gPEthp"}>
                                <div className={"ImgAmi gMnRzx"}>
                                    <img src={estates.url}
                                         width={"60"}
                                         height={"60"}
                                         draggable={"false"}
                                         loading={"lazy"}
                                    />
                                </div>
                            </div>
                            <div className={"content iamnls"}>
                                <div className={"infoWrap fOVNCS"}>
                                    <h1 className={"estateName kPmScS"}>{estates.name}</h1>
                                    <p className={"roomType fGfKPR"}>{estates.phone}</p>
                                    <p className={"basicInfo fYtEsj"}>{estates.address}</p>
                                </div>
                            </div>
                        </div>
                    </li>
                );
            })}
        </ul>
    )
}
export default Estates;