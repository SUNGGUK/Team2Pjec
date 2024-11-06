package menu.hrmanagement.HRRecordCard.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.hrmanagement.HRRecordCard.Model.HRCard01;
import menu.hrmanagement.HRRecordCard.Model.HRCard02;
import menu.hrmanagement.HRRecordCard.Model.HRCard03;
import menu.hrmanagement.HRRecordCard.Model.HRCard04;
import menu.hrmanagement.HRRecordCard.Model.HRCard05;
import menu.hrmanagement.HRRecordCard.Model.HRCard06;
import menu.hrmanagement.HRRecordCard.Model.HRCard07;
import menu.hrmanagement.HRRecordCard.Model.HRCard08;
import menu.hrmanagement.HRRecordCard.Model.HRCard09;
import menu.hrmanagement.HRRecordCard.Model.HRCard10;
import menu.hrmanagement.HRRecordCard.Model.HRCard11;
import menu.hrmanagement.HRRecordCard.Model.HRCard12;
import menu.hrmanagement.HRRecordCard.Model.HRCard13;
import menu.hrmanagement.HRRecordCard.Model.HRCard14;
import menu.hrmanagement.HRRecordCard.Service.HRCardService01;
import menu.hrmanagement.HRRecordCard.Service.HRCardService02;
import menu.hrmanagement.HRRecordCard.Service.HRCardService03;
import menu.hrmanagement.HRRecordCard.Service.HRCardService04;
import menu.hrmanagement.HRRecordCard.Service.HRCardService05;
import menu.hrmanagement.HRRecordCard.Service.HRCardService06;
import menu.hrmanagement.HRRecordCard.Service.HRCardService07;
import menu.hrmanagement.HRRecordCard.Service.HRCardService08;
import menu.hrmanagement.HRRecordCard.Service.HRCardService09;
import menu.hrmanagement.HRRecordCard.Service.HRCardService10;
import menu.hrmanagement.HRRecordCard.Service.HRCardService11;
import menu.hrmanagement.HRRecordCard.Service.HRCardService12;
import menu.hrmanagement.HRRecordCard.Service.HRCardService13;
import menu.hrmanagement.HRRecordCard.Service.HRCardService14;
import mvc.command.CommandHandler;

public class HRCardHandler implements CommandHandler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse res) throws Exception {
        // 각 서비스 클래스 인스턴스 생성 // 各サービスクラスのインスタンスを作成
        HRCardService01 service01 = new HRCardService01();
        HRCardService02 service02 = new HRCardService02();
        HRCardService03 service03 = new HRCardService03();
        HRCardService04 service04 = new HRCardService04();
        HRCardService05 service05 = new HRCardService05();
        HRCardService06 service06 = new HRCardService06();
        HRCardService07 service07 = new HRCardService07();
        HRCardService08 service08 = new HRCardService08();
        HRCardService09 service09 = new HRCardService09();
        HRCardService10 service10 = new HRCardService10();
        HRCardService11 service11 = new HRCardService11();
        HRCardService12 service12 = new HRCardService12();
        HRCardService13 service13 = new HRCardService13(); 
        HRCardService14 service14 = new HRCardService14();

        // 각 서비스에서 전체 직원 목록을 조회 // 各サービスで全社員リストを取得
        List<HRCard01> hrCardList01 = service01.getAllHRCards01();
        List<HRCard02> hrCardList02 = service02.getAllHRCards02();
        List<HRCard03> hrCardList03 = service03.getAllHRCards03();
        List<HRCard04> hrCardList04 = service04.getAllHRCards04();
        List<HRCard05> hrCardList05 = service05.getAllHRCards05();
        List<HRCard06> hrCardList06 = service06.getAllHRCards06();
        List<HRCard07> hrCardList07 = service07.getAllHRCards07();
        List<HRCard08> hrCardList08 = service08.getAllHRCards08();
        List<HRCard09> hrCardList09 = service09.getAllHRCards09();
        List<HRCard10> hrCardList10 = service10.getAllHRCards10();
        List<HRCard11> hrCardList11 = service11.getAllHRCards11();
        List<HRCard12> hrCardList12 = service12.getAllHRCards12();
        List<HRCard13> hrCardList13 = service13.getAllHRCards13(); 
        List<HRCard14> hrCardList14 = service14.getAllHRCards14();

        // 각 리스트를 request에 설정 // 各リストをリクエストに設定
        request.setAttribute("hrCardList01", hrCardList01);
        request.setAttribute("hrCardList02", hrCardList02);
        request.setAttribute("hrCardList03", hrCardList03);
        request.setAttribute("hrCardList04", hrCardList04);
        request.setAttribute("hrCardList05", hrCardList05);
        request.setAttribute("hrCardList06", hrCardList06);
        request.setAttribute("hrCardList07", hrCardList07);
        request.setAttribute("hrCardList08", hrCardList08);
        request.setAttribute("hrCardList09", hrCardList09);
        request.setAttribute("hrCardList10", hrCardList10);
        request.setAttribute("hrCardList11", hrCardList11);
        request.setAttribute("hrCardList12", hrCardList12);
        request.setAttribute("hrCardList13", hrCardList13); 
        request.setAttribute("hrCardList14", hrCardList14);

        // JSP 페이지로 이동하여 결과 표시 // JSPページに移動して結果を表示
        return "/view/HRManagement/hrCard.jsp";
    }
}
