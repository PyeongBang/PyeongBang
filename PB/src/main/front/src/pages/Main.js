import React, {useEffect, useState} from "react";
import "./Main.css";
import Header from "../components/Header";
import ScrollHorizontal from "react-scroll-horizontal";
import Estate from '../components/Estates';

const Main = (props) =>{
    const [nowOption, setOption] = useState(0); //0:건물명, 1:주소, 2:공인중개사

    function ChangeOption(num){
        if(nowOption!=num){
            setOption(num);

            for(let i =0;i<3;i++){
                if(num===i){
                    document.getElementById("onChange"+i).className = 'clLsLT';
                }else{
                    document.getElementById("onChange"+i).className = 'clLsLS';
                }
            }
        }
    }

    function Search(){
        const value = document.getElementById('searchInput').value;

        if(value===""){
            alert("작성된 내용이 없습니다!");
        }else{
            //텍스트 기준으로 지도로 리디렉
        }
    }
    
    //검색(엔터 or 돋보기 클릭 시)지도로 리디렉 필요. 지도에서는 호출된 옵션에 따라 결과 표시

    return (
        <React.Fragment>
            <Header/>
            <div className="styled__Wrap-sc-126ee4m-0 ihEESt">
                <div>
                    <h1>어떤 방을 찾으세요?</h1>
                    <div className="styled__Tab-sc-126ee4m-1 fJFycA">
                        <p id={"onChange0"} className="styled__TabBtn-sc-126ee4m-2 clLsLT"
                            onClick={()=>{
                                ChangeOption(0);
                            }}
                        >건물명</p>
                        <p id={"onChange1"} className="styled__TabBtn-sc-126ee4m-2 clLsLS"
                           onClick={()=>{
                               ChangeOption(1);
                           }}
                        >주소</p>
                        <p id={"onChange2"} className="styled__TabBtn-sc-126ee4m-2 clLsLS"
                           onClick={()=>{
                               ChangeOption(2);
                           }}
                        >공인중개사</p>
                    </div>
                    <form>
                        <label className="styled__InputWindow-sc-126ee4m-3 dcnvxr">
                            <svg width="24" height="24" viewBox="0 0 24 24"
                                 cursor="pointer"
                                 onClick={()=>{
                                     Search();
                                 }}
                            >
                                <g fill="none" fillRule="evenodd">
                                    <path d="M0 0H24V24H0z"></path>
                                    <g stroke="#222" strokeWidth="2" transform="translate(2 2)">
                                        <circle cx="8" cy="8" r="8"></circle>
                                        <path strokeLinecap="round" d="M15 14L19.95 18.95"></path>
                                    </g>
                                </g>
                            </svg>
                            <input id="searchInput" placeholder="지역 또는 단지명을 입력하세요." />
                        </label>
                    </form>
                    <h1>공인중개사</h1>
                </div>
            </div>
            <Estate/>
        </React.Fragment>
  );
}

export default Main;
