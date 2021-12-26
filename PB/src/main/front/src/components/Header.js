import {Grid, Text} from "./Styles";
import Logo from "../images/pyeongbang_logo.png";

const Header = (props) =>{
    return(
        <Grid
            justifyContent="space-between"
            height="85px"
            borderBottom="1px solid rgb(231, 231, 231);"
            padding="0px 20px 0px 30px"
            fontFamily="Spoqa Han Sans, -apple-system, sans-serif"
        >
            <Grid>
                <a href="/">
                    <img src={Logo} alt="다방" />
                </a>
            </Grid>
            <Grid justifyContent="space-between" width="auto" flex="0 0 auto;">
                <Text
                    fontSize="15px"
                    margin="0 0 0 40px"
                    color="rgb(34, 34, 34)"
                    lineHeight="22px"
                    cursor="pointer"
                    hoverColor="rgb(50, 108, 249)"
                    onClick={()=>{
                        alert("test");
                    }}
                >
                    지도
                </Text>
                <Text
                    fontSize="15px"
                    margin="0 0 0 40px"
                    color="rgb(34, 34, 34)"
                    lineHeight="22px"
                    cursor="pointer"
                    hoverColor="rgb(50, 108, 249)"
                    onClick={()=>{
                        alert("test");
                    }}
                >
                    방내놓기
                </Text>
                <Text
                    fontSize="15px"
                    margin="0 0 0 40px"
                    color="rgb(34, 34, 34)"
                    lineHeight="22px"
                    cursor="pointer"
                    hoverColor="rgb(50, 108, 249)"
                    onClick={()=>{
                        alert("test");
                    }}
                >
                    승계 게시판
                </Text>
                <Text
                    fontSize="15px"
                    margin="0 0 0 40px"
                    color="rgb(34, 34, 34)"
                    lineHeight="22px"
                >
                    김태성 님, 안녕하세요!
                </Text>
            </Grid>
        </Grid>
    );
};

export default Header;
