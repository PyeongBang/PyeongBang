/* global kakao */
import React, {useEffect} from "react";
import './Content.css';
import MapContainer, {SetMarker} from "../components/MapContainer";
import Header from '../components/Header';

const Content = () => {
    return (
        <div>
            <Header/>
            <div className={"OjqKy"}>
                <div className={"kGOyKU"}>
                    <nav className={"dDMplN"}>
                        <div className={"gEEvZj"}>
                            <button className={"hybuLu"}  onClick={()=>{
                                SetMarker(["CU 대구대점", "계엄령", "김안에밥", "명품부동산"]);
                            }}>
                                <span>전체 방 3개</span>
                            </button>
                        </div>
                    </nav>
                    <div className={"tCKON"}>
                        {/*<h1>리스트</h1>*/}
                    </div>
                </div>
                <div className={"foUutm"}>
                    <div className={"lovQZK"}>
                    </div>
                    <div id={'Map'}>
                        <MapContainer></MapContainer>
                    </div>
                </div>
            </div>
        </div>
    );
}
export default Content;