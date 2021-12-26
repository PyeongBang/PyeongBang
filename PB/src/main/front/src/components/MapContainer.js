import React, {useEffect} from 'react';

const {kakao} = window;
let markers = [];

export const SetMarker=(keyword)=>{ //지도 마커 표시, 검색
    hideMarkers()
    const container = document.getElementById('myMap');
    const options = {
        center:new kakao.maps.LatLng(35.89500, 128.84500),
        level:5,
    };
    const map = new kakao.maps.Map(container, options);

    const ps = new kakao.maps.services.Places();
    for(let i = 0;i<keyword.length;i++){
        ps.keywordSearch(keyword[i], placeSearchCB);
    }

    function placeSearchCB(data, status, pagination){
        if(status === kakao.maps.services.Status.OK){
            let bounds = new kakao.maps.LatLngBounds();

            for(let i=0;i<data.length;i++){
                displayMarker(data[i]);
                bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
            }
            map.setBounds(bounds);
        }
    }

    function displayMarker(place){
        let marker=new kakao.maps.Marker({
            map:map,
            position: new kakao.maps.LatLng(place.y, place.x)
        });

        marker.setMap(map);
        markers.push(marker);
    }

    function hideMarkers(){
        for(let i = 0; i<markers.length;i++){
            markers[i].setMap(null);
        }
    }
}

const MapContainer=()=>{
    useEffect(()=>{
        const container = document.getElementById('myMap');
        const options = {
            center:new kakao.maps.LatLng(35.89500, 128.84500),
            level:5,
        };

        const map = new kakao.maps.Map(container, options);
    }, []);




    return(
        <div id={'myMap'} style={{
            width:'73.9vw',
            height:'88.5vh',
            position: 'relative',
            tabindex: 0
        }}>
        </div>
    )
}
export default MapContainer;