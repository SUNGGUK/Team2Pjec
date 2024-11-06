package menu.BasicSettings.EmployeeRegistration.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.BasicSettings.EmployeeRegistration.Service.EmployeeRegistrationService;
import menu.BasicSettings.EmployeeRegistration.model.*;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeRegistrationController extends HttpServlet {

    private EmployeeRegistrationService registrationService = new EmployeeRegistrationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "taishoku":
                    taishoku taishokuData = new taishoku();
                    taishokuData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    taishokuData.setZyoutai(request.getParameter("zyoutai"));
                    taishokuData.setTaishoku_kubun(request.getParameter("taishoku_kubun"));
                    taishokuData.setTaishoku_bi(java.sql.Date.valueOf(request.getParameter("taishoku_bi")));
                    taishokuData.setTaishoku_ziyuu(request.getParameter("taishoku_ziyuu"));
                    taishokuData.setTaishoku_go_renrakusaki(request.getParameter("taishoku_go_renrakusaki"));
                    taishokuData.setChuukan_seisan_umu(request.getParameter("chuukan_seisan_umu").charAt(0));
                    taishokuData.setTaishoku_seisan_umu(request.getParameter("taishoku_seisan_umu").charAt(0));
                    taishokuData.setTaishoku_kin(Double.parseDouble(request.getParameter("taishoku_kin")));
                    taishokuData.setBikou(request.getParameter("bikou").getBytes());
                    registrationService.saveTaishoku(taishokuData);
                    break;

                case "shoubatsu":
                    shoubatsu shoubatsuData = new shoubatsu();
                    shoubatsuData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    shoubatsuData.setShoubatsu_mei(request.getParameter("shoubatsu_mei"));
                    shoubatsuData.setKantoku_kikan(request.getParameter("kantoku_kikan"));
                    shoubatsuData.setShoubatsu_bi(java.sql.Date.valueOf(request.getParameter("shoubatsu_bi")));
                    shoubatsuData.setNaiyou(request.getParameter("naiyou"));
                    shoubatsuData.setBikou(request.getParameter("bikou"));
                    registrationService.saveShoubatsu(shoubatsuData);
                    break;

                case "shokui_settei":
                    shokui_settei shokuiSetteiData = new shokui_settei();
                    shokuiSetteiData.setShain_id(Integer.parseInt(request.getParameter("shain_id")));
                    shokuiSetteiData.setShokui_mei(request.getParameter("shokui_mei"));
                    registrationService.saveShokuiSettei(shokuiSetteiData);
                    break;

                case "shikaku_menkyou":
                    shikaku_menkyou shikakuData = new shikaku_menkyou();
                    shikakuData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    shikakuData.setShikaku_mei(request.getParameter("shikaku_mei"));
                    shikakuData.setHakkyuu_bi(java.sql.Date.valueOf(request.getParameter("hakkyuu_bi")));
                    shikakuData.setHakkyuu_kikan_mei(request.getParameter("hakkyuu_kikan_mei"));
                    shikakuData.setShikakushou_bangou(request.getParameter("shikakushou_bangou"));
                    shikakuData.setBiko(request.getParameter("biko"));
                    registrationService.saveShikakuMenkyou(shikakuData);
                    break;

                case "shidai_hoken_zyouhou":
                    shidai_hoken_zyouhou shidaiHokenData = new shidai_hoken_zyouhou();
                    shidaiHokenData.setHoken_ID(Integer.parseInt(request.getParameter("hoken_ID")));
                    shidaiHokenData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    shidaiHokenData.setHoken_shurui(request.getParameter("hoken_shurui"));
                    shidaiHokenData.setTouroku_bangou(request.getParameter("touroku_bangou"));
                    shidaiHokenData.setShutoku_bi(java.sql.Date.valueOf(request.getParameter("shutoku_bi")));
                    shidaiHokenData.setSousitsu_bi(java.sql.Date.valueOf(request.getParameter("sousitsu_bi")));
                    registrationService.saveShidaiHoken(shidaiHokenData);
                    break;

                case "shain_touroku":
                    shain_touroku shainTourokuData = new shain_touroku();
                    shainTourokuData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    shainTourokuData.setKoyou_keitai(request.getParameter("koyou_keitai"));
                    shainTourokuData.setShain_namae(request.getParameter("shain_namae"));
                    shainTourokuData.setShain_eigo_namae(request.getParameter("shain_eigo_namae"));
                    shainTourokuData.setNyuusha_bi(java.sql.Date.valueOf(request.getParameter("nyuusha_bi")));
                    shainTourokuData.setTaisha_bi(java.sql.Date.valueOf(request.getParameter("taisha_bi")));
                    shainTourokuData.setBu(request.getParameter("bu"));
                    shainTourokuData.setYakushoku(request.getParameter("yakushoku"));
                    shainTourokuData.setNai_gaikokuzin(request.getParameter("nai_gaikokuzin"));
                    shainTourokuData.setZyuumin_bangou(request.getParameter("zyuumin_bangou"));
                    shainTourokuData.setZyuusho(request.getParameter("zyuusho"));
                    shainTourokuData.setDenwa_bangou(request.getParameter("denwa_bangou"));
                    shainTourokuData.setKeitai_bangou(request.getParameter("keitai_bangou"));
                    shainTourokuData.setMeiru_adoresu(request.getParameter("meiru_adoresu"));
                    shainTourokuData.setSns(request.getParameter("sns"));
                    shainTourokuData.setBikou(request.getParameter("bikou"));
                    registrationService.saveShainTouroku(shainTourokuData);
                    break;

                case "kyuuyo_shidai_hoken":
                    kyuuyo_shidai_hoken kyuuyoData = new kyuuyo_shidai_hoken();
                    kyuuyoData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    kyuuyoData.setKokumin_nenkin(request.getParameter("kokumin_nenkin").charAt(0));
                    kyuuyoData.setKenko_hoken(request.getParameter("kenko_hoken").charAt(0));
                    kyuuyoData.setGenmen1(Integer.parseInt(request.getParameter("genmen1")));
                    kyuuyoData.setKaigo_hoken(request.getParameter("kaigo_hoken").charAt(0));
                    kyuuyoData.setGenmen2(Integer.parseInt(request.getParameter("genmen2")));
                    kyuuyoData.setKoyo_hoken(request.getParameter("koyo_hoken").charAt(0));
                    kyuuyoData.setRodo_sha(request.getParameter("rodo_sha").charAt(0));
                    kyuuyoData.setZeigaku(Integer.parseInt(request.getParameter("zeigaku")));
                    kyuuyoData.setSeinen_zei(request.getParameter("seinen_zei").charAt(0));
                    kyuuyoData.setGenmen3(Integer.parseInt(request.getParameter("genmen3")));
                    kyuuyoData.setJigyo_sha(request.getParameter("jigyo_sha").charAt(0));
                    kyuuyoData.setHiyatoi(request.getParameter("hiyatoi").charAt(0));
                    kyuuyoData.setSonota_sha(request.getParameter("sonota_sha").charAt(0));
                    kyuuyoData.setRodo_jigyo_sha(request.getParameter("rodo_jigyo_sha").charAt(0));
                    kyuuyoData.setMenjo(request.getParameter("menjo").charAt(0));
                    kyuuyoData.setGaito_nashi1(request.getParameter("gaito_nashi1").charAt(0));
                    kyuuyoData.setShinki_80_1(request.getParameter("shinki_80_1").charAt(0));
                    kyuuyoData.setShinki_90_1(request.getParameter("shinki_90_1").charAt(0));
                    kyuuyoData.setGaito_nashi2(request.getParameter("gaito_nashi2").charAt(0));
                    kyuuyoData.setShinki_80_2(request.getParameter("shinki_80_2").charAt(0));
                    kyuuyoData.setShinki_90_2(request.getParameter("shinki_90_2").charAt(0));
                    kyuuyoData.setKihonkyuu(Integer.parseInt(request.getParameter("kihonkyuu")));
                    kyuuyoData.setNenkin_shotoku(Integer.parseInt(request.getParameter("nenkin_shotoku")));
                    kyuuyoData.setKenko_shotoku(Integer.parseInt(request.getParameter("kenko_shotoku")));
                    kyuuyoData.setKoyo_shotoku(Integer.parseInt(request.getParameter("koyo_shotoku")));
                    kyuuyoData.setSangyou_saigai(Integer.parseInt(request.getParameter("sangyou_saigai")));
                    kyuuyoData.setGinkou_mei(request.getParameter("ginkou_mei"));
                    kyuuyoData.setKouza_bangou(request.getParameter("kouza_bangou"));
                    registrationService.saveKyuuyoShidaiHoken(kyuuyoData);
                    break;

                case "kyouiku_kunren":
                    kyouiku_kunren kyouikuData = new kyouiku_kunren();
                    kyouikuData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    kyouikuData.setKyouiku_shurui(request.getParameter("kyouiku_shurui"));
                    kyouikuData.setKyouiku_mei(request.getParameter("kyouiku_mei"));
                    kyouikuData.setKaishi_bi(java.sql.Date.valueOf(request.getParameter("kaishi_bi")));
                    kyouikuData.setShuuryou_bi(java.sql.Date.valueOf(request.getParameter("shuuryou_bi")));
                    kyouikuData.setKyouiku_kikan_mei(request.getParameter("kyouiku_kikan_mei"));
                    kyouikuData.setKyouiku_hi(Double.parseDouble(request.getParameter("kyouiku_hi")));
                    kyouikuData.setKanpu_kyouiku_hi(Double.parseDouble(request.getParameter("kanpu_kyouiku_hi")));
                    registrationService.saveKyouikuKunren(kyouikuData);
                    break;

                case "keireki_zyouhou":
                    keireki_zyouhou keirekiData = new keireki_zyouhou();
                    keirekiData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    keirekiData.setKaisha_mei(request.getParameter("kaisha_mei"));
                    keirekiData.setTasha_nyuusha_bi(java.sql.Date.valueOf(request.getParameter("tasha_nyuusha_bi")));
                    keirekiData.setTasha_taishoku_bi(java.sql.Date.valueOf(request.getParameter("tasha_taishoku_bi")));
                    keirekiData.setKinmu_kikan(Integer.parseInt(request.getParameter("kinmu_kikan")));
                    keirekiData.setSaishuu_yakushoku(request.getParameter("saishuu_yakushoku"));
                    keirekiData.setTantou_shokumu(request.getParameter("tantou_shokumu"));
                    keirekiData.setTaishoku_ziyuu(request.getParameter("taishoku_ziyuu"));
                    registrationService.saveKeirekiZyouhou(keirekiData);
                    break;

                case "huyou_kazoku":
                    huyou_kazoku kazokuData = new huyou_kazoku();
                    kazokuData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    kazokuData.setNamae(request.getParameter("namae"));
                    kazokuData.setKankei(request.getParameter("kankei"));
                    kazokuData.setZyuumin_touroku_bangou(request.getParameter("zyuumin_touroku_bangou"));
                    kazokuData.setShougai_umu(request.getParameter("shougai_umu").charAt(0));
                    kazokuData.setZei_kouzyo_umu(request.getParameter("zei_kouzyo_umu").charAt(0));
                    kazokuData.setKenkou_hoken_umu(request.getParameter("kenkou_hoken_umu").charAt(0));
                    kazokuData.setDoukyo_umu(request.getParameter("doukyo_umu").charAt(0));
                    kazokuData.setNen20_ika_ko_umu(request.getParameter("nen20_ika_ko_umu").charAt(0));
                    registrationService.saveHuyouKazoku(kazokuData);
                    break;

                case "hoshounin":
                    hoshounin hoshouninData = new hoshounin();
                    hoshouninData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    hoshouninData.setHoshounin_mei(request.getParameter("hoshounin_mei"));
                    hoshouninData.setKankei(request.getParameter("kankei"));
                    hoshouninData.setZyuumin_touroku_bangou(request.getParameter("zyuumin_touroku_bangou"));
                    hoshouninData.setHoshou_kingaku(Double.parseDouble(request.getParameter("hoshou_kingaku")));
                    hoshouninData.setHoshou_bi(java.sql.Date.valueOf(request.getParameter("hoshou_bi")));
                    hoshouninData.setSyuuryou_bi(java.sql.Date.valueOf(request.getParameter("syuuryou_bi")));
                    hoshouninData.setDenwa_bangou(request.getParameter("denwa_bangou"));
                    registrationService.saveHoshounin(hoshouninData);
                    break;

                case "heieki_zyouhou":
                    heieki_zyouhou heiekiData = new heieki_zyouhou();
                    heiekiData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    heiekiData.setHeieki_kubun(request.getParameter("heieki_kubun"));
                    heiekiData.setGun_betsu(request.getParameter("gun_betsu"));
                    heiekiData.setHukumu_kaishi_bi(java.sql.Date.valueOf(request.getParameter("hukumu_kaishi_bi")));
                    heiekiData.setHukumu_shuuryou_bi(java.sql.Date.valueOf(request.getParameter("hukumu_shuuryou_bi")));
                    heiekiData.setSaishuu_kaikyuu(request.getParameter("saishuu_kaikyuu"));
                    heiekiData.setHeika(request.getParameter("heika"));
                    heiekiData.setMiryou_ziyuu(request.getParameter("miryou_ziyuu"));
                    registrationService.saveHeiekiZyouhou(heiekiData);
                    break;

                case "hatsurei":
                    hatsurei hatsureiData = new hatsurei();
                    hatsureiData.setShain_ID(Integer.parseInt(request.getParameter("shain_ID")));
                    hatsureiData.setHatsurei_bi(java.sql.Date.valueOf(request.getParameter("hatsurei_bi")));
                    hatsureiData.setBu(request.getParameter("bu"));
                    hatsureiData.setYakushoku_mei(request.getParameter("yakushoku_mei"));
                    hatsureiData.setShokumu_mei(request.getParameter("shokumu_mei"));
                    hatsureiData.setBikou(request.getParameter("bikou"));
                    registrationService.saveHatsurei(hatsureiData);
                    break;

                case "busho_settei":
                    busho_settei bushoSetteiData = new busho_settei();
                    bushoSetteiData.setShain_id(Integer.parseInt(request.getParameter("shain_id")));
                    bushoSetteiData.setBusho_mei(request.getParameter("busho_mei"));
                    registrationService.saveBushoSettei(bushoSetteiData);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid action type: " + action);
            }
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
