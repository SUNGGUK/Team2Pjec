<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="menu.BasicSettings.UserInfo.Model.UserInfo"%>
<%@ page import="menu.BasicSettings.UserInfo.Model.UserInfo.KaishaZyouhou"%>
<%@ page import="menu.BasicSettings.UserInfo.Model.UserInfo.KyuuyoShikyuuZyouhou"%>
<%@ page import="menu.BasicSettings.UserInfo.Model.UserInfo.Tantousha_Zyouhou"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%

UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

if (userInfo == null) {
    userInfo = new UserInfo();
    userInfo.setKaishaZyouhou(new UserInfo.KaishaZyouhou());
    userInfo.setKyuuyoShikyuuZyouhou(new UserInfo.KyuuyoShikyuuZyouhou());
    userInfo.setTantoushaZyouhou(new UserInfo.Tantousha_Zyouhou());
    session.setAttribute("userInfo", userInfo);
}
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE html>
<html>
<head>
<title>ユーザー情報</title>
<style>
.container { width: 90%; margin: auto; }
.section { margin-top: 20px; }
.section-title { font-weight: bold; }
.divider { border-top: 2px solid #007bff; margin-top: 10px; margin-bottom: 20px; width: 100%; }
.form-row { display: flex; align-items: center; margin-bottom: 10px; }
.label-box { width: 120px; background-color: #E0F7FA; padding: 6px; font-weight: bold; text-align: left; margin-right: 10px; box-sizing: border-box; font-size: 0.9em; }
.input-box { flex: 1; padding: 6px; border: 1px solid #ccc; font-size: 0.9em; }
.postal-search-btn { padding: 6px 20px; font-size: 0.9em; }
.phone-container { display: flex; align-items: center; }
.phone-select, .phone-input { padding: 6px; width: 50px; text-align: center; border: 1px solid #ccc; margin-right: 3px; box-sizing: border-box; font-size: 0.9em; }
.btn { padding: 6px 10px; font-size: 0.9em; }
.btn-primary { background-color: #007bff; color: #fff; border: none; }
.btn-secondary { background-color: #6c757d; color: #fff; border: none; }
.flex-container { display: flex; justify-content: space-between; }
.half-width { width: 48%; }
.box-container { border: 1px solid #007bff; padding: 10px; box-sizing: border-box; width: 100%; }
.half-box-container { width: 48%; }
</style>
</head>
<body>
    <div class="container">
        <h2>ユーザー情報</h2>
        <p>
            <span class="label">*</span> 必須項目です。
        </p>

        <form method="post" action="<%=request.getContextPath()%>/saveUserInfo.do">
            <input type="hidden" name="action" value="save" />

            <div class="flex-container">
                <div class="section half-width">
                    <h3 class="section-title">会社情報</h3>
                    <div class="divider"></div>
                    <div class="box-container">
                        <div class="form-row">
                            <label class="label-box">* 会社名:</label> 
                            <input type="text" name="kaishaMei" class="input-box" value="<%=userInfo.getKaishaZyouhou().getKaisha_mei() != null ? userInfo.getKaishaZyouhou().getKaisha_mei() : ""%>">
                        </div>
                        <div class="form-row">
                            <label class="label-box">* 代表者役職:</label> 
                            <input type="text" name="shachouYakushoku" class="input-box" value="<%=userInfo.getKaishaZyouhou().getShachou_yakushoku() != null ? userInfo.getKaishaZyouhou().getShachou_yakushoku() : ""%>">
                            <label class="label-box">* 代表者名:</label> 
                            <input type="text" name="shachouMei" class="input-box" value="<%=userInfo.getKaishaZyouhou().getShachou_mei() != null ? userInfo.getKaishaZyouhou().getShachou_mei() : ""%>">
                        </div>
                        <div class="form-row">
                            <label class="label-box">* 事業者番号:</label> 
                            <input type="text" name="zigyouBangou" class="input-box" value="<%=userInfo.getKaishaZyouhou().getZigyou_bangou() != 0 ? userInfo.getKaishaZyouhou().getZigyou_bangou() : ""%>">
                            <label class="label-box">法人番号:</label> 
                            <input type="text" name="houzinBangou" class="input-box" value="<%=userInfo.getKaishaZyouhou().getHouzin_bangou() != 0 ? userInfo.getKaishaZyouhou().getHouzin_bangou() : ""%>">
                        </div>
                        <div class="form-row">
                            <label class="label-box">設立日:</label> 
                            <input type="date" name="setsuritsuBi" class="input-box" value="<%=userInfo.getKaishaZyouhou().getSetsuritsu_bi() != null ? sdf.format(userInfo.getKaishaZyouhou().getSetsuritsu_bi()) : "" %>">
                            <label class="label-box">ウェブサイト:</label> 
                            <input type="text" name="ulebusaito" class="input-box" value="<%=userInfo.getKaishaZyouhou().getUlebusaito() != null ? userInfo.getKaishaZyouhou().getUlebusaito() : ""%>">
                        </div>
                        <div class="form-row">
                            <label class="label-box">事業所住所:</label> 
                            <input type="text" name="yubinbango" class="input-box" placeholder="郵便番号" value="<%=userInfo.getKaishaZyouhou().getYubinbango() != null ? userInfo.getKaishaZyouhou().getYubinbango() : ""%>">
                            <button type="button" class="btn postal-search-btn" onclick="openPostalCodePopup()">郵便番号検索</button>
                            <input type="text" name="zigyouzyouZyuusho" class="input-box" placeholder="住所" value="<%=userInfo.getKaishaZyouhou().getZigyouzyou_zyuusho() != null ? userInfo.getKaishaZyouhou().getZigyouzyou_zyuusho() : ""%>">
                        </div>
                        <div class="form-row">
                            <label class="label-box">電話番号:</label>
                            <div class="phone-container">
                                <select class="phone-select" name="denwaPrefix">
                                    <option value="">選択</option>
                                    <option value="">代表(なし)</option>
                                    <option value="050">インターネット(050)</option>
                                    <option value="0507">インターネット(0507)</option>
                                    <option value="070">インターネット(070)</option>
                                    <option value="0303">インターネット(0303)</option>
                                    <option value="0504">インターネット(0504)</option>
                                    <option value="02">ソウル(02)</option>
                                    <option value="051">釜山(051)</option>
                                    <option value="053">大邱(053)</option>
                                    <option value="032">仁川(032)</option>
                                    <option value="062">光州(062)</option>
                                    <option value="042">大田(042)</option>
                                    <option value="052">蔚山(052)</option>
                                    <option value="044">世宗(044)</option>
                                    <option value="031">京畿(031)</option>
                                    <option value="033">江原(033)</option>
                                    <option value="043">忠北(043)</option>
                                    <option value="041">忠南(041)</option>
                                    <option value="063">全北(063)</option>
                                    <option value="061">全南(061)</option>
                                    <option value="054">慶北(054)</option>
                                    <option value="055">慶南(055)</option>
                                    <option value="064">済州(064)</option>
                                </select>
                                <input type="text" class="phone-input" name="denwaFirst" maxlength="4"> 
                                <span>-</span> 
                                <input type="text" class="phone-input" name="denwaLast" maxlength="4">
                            </div>
                            <label class="label-box">ファックス番号:</label>
                            <div class="phone-container">
                                <select class="phone-select" name="faksPrefix">
                                    <option value="">選択</option>
                                    <option value="">代表(なし)</option>
                                    <option value="050">インターネット(050)</option>
                                    <option value="0507">インターネット(0507)</option>
                                    <option value="070">インターネット(070)</option>
                                    <option value="0303">インターネット(0303)</option>
                                    <option value="0504">インターネット(0504)</option>
                                    <option value="02">ソウル(02)</option>
                                    <option value="051">釜山(051)</option>
                                    <option value="053">大邱(053)</option>
                                    <option value="032">仁川(032)</option>
                                    <option value="062">光州(062)</option>
                                    <option value="042">大田(042)</option>
                                    <option value="052">蔚山(052)</option>
                                    <option value="044">世宗(044)</option>
                                    <option value="031">京畿(031)</option>
                                    <option value="033">江原(033)</option>
                                    <option value="043">忠北(043)</option>
                                    <option value="041">忠南(041)</option>
                                    <option value="063">全北(063)</option>
                                    <option value="061">全南(061)</option>
                                    <option value="054">慶北(054)</option>
                                    <option value="055">慶南(055)</option>
                                    <option value="064">済州(064)</option>
                                </select>
                                <input type="text" class="phone-input" name="faksFirst" maxlength="4"> 
                                <span>-</span> 
                                <input type="text" class="phone-input" name="faksLast" maxlength="4">
                            </div>
                        </div>

                        <div class="form-row">
                            <label class="label-box">業種:</label> 
                            <input type="text" name="zigyouShurui" class="input-box" value="<%=userInfo.getKaishaZyouhou().getZigyou_shurui() != null ? userInfo.getKaishaZyouhou().getZigyou_shurui() : ""%>">
                            <label class="label-box">事業内容:</label> 
                            <input type="text" name="zigyouNaiyou" class="input-box" value="<%=userInfo.getKaishaZyouhou().getZigyou_naiyou() != null ? userInfo.getKaishaZyouhou().getZigyou_naiyou() : ""%>">
                        </div>
                    </div>
                </div>

                <div class="section half-width">
                    <h3 class="section-title">担当者情報</h3>
                    <div class="divider"></div>
                    <div class="box-container">
                        <div class="form-row">
                            <label class="label-box">* 氏名:</label> 
                            <input type="text" name="namae" class="input-box" value="<%=userInfo.getTantoushaZyouhou().getNamae() != null ? userInfo.getTantoushaZyouhou().getNamae() : ""%>">
                        </div>
                        <div class="form-row">
                            <label class="label-box">部門:</label> 
                            <input type="text" name="bu" class="input-box" value="<%=userInfo.getTantoushaZyouhou().getBu() != null ? userInfo.getTantoushaZyouhou().getBu() : ""%>">
                            <button type="button" class="btn">管理</button>
                        </div>
                        <div class="form-row">
                            <label class="label-box">役職:</label> 
                            <input type="text" name="yakushoku" class="input-box" value="<%=userInfo.getTantoushaZyouhou().getYakushoku() != null ? userInfo.getTantoushaZyouhou().getYakushoku() : ""%>">
                            <button type="button" class="btn">管理</button>
                        </div>
                        <div class="form-row">
                            <label class="label-box">電話番号:</label>
                            <div class="phone-container">
                                <select class="phone-select" name="tantoushaDenwaPrefix">
                                    <option value="">選択</option>
                                    <option value="">代表(なし)</option>
                                    <option value="050">インターネット(050)</option>
                                    <option value="0507">インターネット(0507)</option>
                                    <option value="070">インターネット(070)</option>
                                    <option value="0303">インターネット(0303)</option>
                                    <option value="0504">インターネット(0504)</option>
                                    <option value="02">ソウル(02)</option>
                                    <option value="051">釜山(051)</option>
                                    <option value="053">大邱(053)</option>
                                    <option value="032">仁川(032)</option>
                                    <option value="062">光州(062)</option>
                                    <option value="042">大田(042)</option>
                                    <option value="052">蔚山(052)</option>
                                    <option value="044">世宗(044)</option>
                                    <option value="031">京畿(031)</option>
                                    <option value="033">江原(033)</option>
                                    <option value="043">忠北(043)</option>
                                    <option value="041">忠南(041)</option>
                                    <option value="063">全北(063)</option>
                                    <option value="061">全南(061)</option>
                                    <option value="054">慶北(054)</option>
                                    <option value="055">慶南(055)</option>
                                    <option value="064">済州(064)</option>
                                </select>
                                <input type="text" class="phone-input" name="tantoushaDenwaFirst" maxlength="4"> 
                                <span>-</span> 
                                <input type="text" class="phone-input" name="tantoushaDenwaLast" maxlength="4">
                            </div>
                        </div>
                        <div class="form-row">
                            <label class="label-box">携帯電話番号:</label>
                            <div class="phone-container">
                                <select class="phone-select" name="keitaiPrefix">
                                    <option value="">選択</option>
                                    <option value="">代表(なし)</option>
                                    <option value="050">インターネット(050)</option>
                                    <option value="0507">インターネット(0507)</option>
                                    <option value="070">インターネット(070)</option>
                                    <option value="0303">インターネット(0303)</option>
                                    <option value="0504">インターネット(0504)</option>
                                    <option value="02">ソウル(02)</option>
                                    <option value="051">釜山(051)</option>
                                    <option value="053">大邱(053)</option>
                                    <option value="032">仁川(032)</option>
                                    <option value="062">光州(062)</option>
                                    <option value="042">大田(042)</option>
                                    <option value="052">蔚山(052)</option>
                                    <option value="044">世宗(044)</option>
                                    <option value="031">京畿(031)</option>
                                    <option value="033">江原(033)</option>
                                    <option value="043">忠北(043)</option>
                                    <option value="041">忠南(041)</option>
                                    <option value="063">全北(063)</option>
                                    <option value="061">全南(061)</option>
                                    <option value="054">慶北(054)</option>
                                    <option value="055">慶南(055)</option>
                                    <option value="064">済州(064)</option>
                                </select>
                                <input type="text" class="phone-input" name="keitaiFirst" maxlength="4"> 
                                <span>-</span> 
                                <input type="text" class="phone-input" name="keitaiLast" maxlength="4">
                            </div>
                        </div>
                        <div class="form-row">
                            <label class="label-box">メールアドレス:</label> 
                            <input type="text" name="meiruAd" class="input-box" value="<%=userInfo.getTantoushaZyouhou().getMeiru_adoresu() != null ? userInfo.getTantoushaZyouhou().getMeiru_adoresu() : ""%>">
                        </div>
                    </div>
                </div>
            </div>

            <div class="section half-box-container">
                <h3 class="section-title">給与支給情報</h3>
                <div class="divider"></div>
                <div class="box-container">
                    <div class="form-row">
                        <label class="label-box">給与算定期間:</label>
                        <input type="date" name="kyuuyoSeisanKikan" class="input-box" value="<%=userInfo.getKyuuyoShikyuuZyouhou().getKyuuyo_seisan_kikan() != null ? sdf.format(userInfo.getKyuuyoShikyuuZyouhou().getKyuuyo_seisan_kikan()) : "" %>">
                        <label class="label-box">給与支給日:</label>
                        <input type="date" name="kyuuyoShikyuuBi" class="input-box" value="<%=userInfo.getKyuuyoShikyuuZyouhou().getKyuuyo_shikyuu_bi() != null ? sdf.format(userInfo.getKyuuyoShikyuuZyouhou().getKyuuyo_shikyuu_bi()) : "" %>">
                    </div>
                    <div class="form-row" style="display: flex; gap: 10px; align-items: center;">
                        <div style="display: flex; align-items: center;">
                            <label class="label-box" style="width: auto;">金融機関:</label>
                            <input type="text" name="kinyuuKikan" class="input-box" style="width: 130px;" value="<%= userInfo.getKyuuyoShikyuuZyouhou().getKinyuu_kikan() != null ? userInfo.getKyuuyoShikyuuZyouhou().getKinyuu_kikan() : "" %>">
                        </div>
                        <div style="display: flex; align-items: center;">
                            <label class="label-box" style="width: auto;">口座番号:</label>
                            <input type="text" name="kouzaBangou" class="input-box" style="width: 130px;" value="<%= userInfo.getKyuuyoShikyuuZyouhou().getKouza_bangou() != null ? userInfo.getKyuuyoShikyuuZyouhou().getKouza_bangou() : "" %>">
                        </div>
                        <div style="display: flex; align-items: center;">
                            <label class="label-box" style="width: auto;">預金主:</label>
                            <input type="text" name="yokinshu" class="input-box" style="width: 130px;" value="<%= userInfo.getKyuuyoShikyuuZyouhou().getYokinshu() != null ? userInfo.getKyuuyoShikyuuZyouhou().getYokinshu() : "" %>">
                        </div>
                    </div>
                </div>
            </div>
            <div style="text-align: center; margin-top: 20px;">
                <input type="submit" class="btn btn-primary" value="保存">
                <button type="button" class="btn btn-secondary" onclick="window.location.href='UserInfo.jsp?action=cancel'">キャンセル</button>
            </div>
        </form>
    </div>
</body>
</html>
