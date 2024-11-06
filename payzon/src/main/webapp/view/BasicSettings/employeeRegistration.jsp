<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>社員登録</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        /* 基本スタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            background-color: #f9f9f9;
        }
        .container {
            display: flex;
            width: 100%;
        }
        .sidebar {
            width: 200px;
            background-color: #f2f2f2;
            padding: 20px;
            position: fixed;
            height: 100%;
            overflow-y: auto;
        }
        .sidebar .profile-pic {
            text-align: center;
            margin-bottom: 20px;
        }
        .sidebar .profile-pic img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            border: 2px solid #ccc;
        }
        .sidebar button {
            width: 100%;
            margin: 5px 0;
            padding: 10px;
            background-color: #333;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .sidebar button:hover {
            background-color: #555;
        }
        .content {
            margin-left: 220px;
            padding: 20px;
            width: calc(100% - 240px);
        }
        .section {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        h1, h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table th, table td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        .buttons {
            text-align: center;
            margin-top: 20px;
        }
        .buttons button {
            padding: 10px 20px;
            margin: 5px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 3px;
        }
        .buttons button:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function scrollToSection(sectionId) {
            document.getElementById(sectionId).scrollIntoView({ behavior: 'smooth' });
        }

        // サイドバー固定スクロール効果
        window.onscroll = function() {
            const sidebar = document.querySelector('.sidebar');
            const sticky = sidebar.offsetTop;
            if (window.pageYOffset >= sticky) {
                sidebar.classList.add("sticky");
            } else {
                sidebar.classList.remove("sticky");
            }
        };
    </script>
</head>
<body>
    <div class="container">
        <!-- サイドバー -->
        <div class="sidebar">
            <div class="profile-pic">
                <img src="default_profile.png" alt="社員写真">
                <p>社員写真を登録してください</p>
                <button>登録</button>
                <button>削除</button>
                <button>人事記録カード</button>
            </div>
            <div class="info-buttons">
                <button onclick="scrollToSection('salary-section')">給与 & 4大保険</button>
                <button onclick="scrollToSection('family-section')">扶養家族</button>
                <button onclick="scrollToSection('education-section')">学歴</button>
                <button onclick="scrollToSection('career-section')">経歴</button>
                <button onclick="scrollToSection('military-section')">兵役</button>
            </div>
        </div>

        <!-- コンテンツ -->
        <div class="content">
            <form action="EmployeeRegistrationController" method="post">
                <input type="hidden" name="action" value="saveEmployeeData">

                <!-- 基本情報 -->
                <div class="section" id="basic-info-section">
                    <h2>基本情報</h2>
                    <table>
                        <tr>
                            <td>社員番号</td>
                            <td><input type="text" name="shain_ID" value="No-140043" readonly></td>
                            <td>雇用形態*</td>
                            <td>
                                <select name="koyou_keitai">
                                    <option value="">選択してください</option>
                                    <!-- オプション追加 -->
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>氏名（日本語）*</td>
                            <td><input type="text" name="name_korean" required></td>
                            <td>氏名（英語）</td>
                            <td><input type="text" name="name_english"></td>
                        </tr>
                        <tr>
                            <td>部署</td>
                            <td><select name="department"><option value="">選択してください</option></select></td>
                            <td>職位</td>
                            <td><select name="position"><option value="">選択してください</option></select></td>
                        </tr>
                        <tr>
                            <td>内/外国人</td>
                            <td><select name="nationality"><option value="">選択してください</option></select></td>
                            <td>住所</td>
                            <td><input type="text" name="address"></td>
                        </tr>
                    </table>
                </div>

                <!-- 給与 & 4大保険 -->
                <div class="section" id="salary-section">
                    <h2>給与 & 4大保険</h2>
                    <table>
                        <tr>
                            <th>4大保険</th>
                            <td>
                                <input type="checkbox" name="kokumin_nenkin" value="Y"> 国民年金
                                <input type="checkbox" name="kenko_hoken" value="Y"> 健康保険
                                <input type="checkbox" name="koyo_hoken" value="Y"> 雇用保険
                                <input type="checkbox" name="sangyou_saigai" value="Y"> 労災保険
                            </td>
                        </tr>
                        <tr>
                            <td>基本給/賃金</td>
                            <td><input type="text" name="kihonkyuu" placeholder="円"></td>
                        </tr>
                        <tr>
                            <td>給与口座</td>
                            <td>
                                <select name="ginkou_mei">
                                    <option value="">選択してください</option>
                                    <!-- 銀行リスト追加 -->
                                </select>
                                <input type="text" name="kouza_bangou" placeholder="口座番号">
                            </td>
                        </tr>
                    </table>
                </div>

                <!-- 扶養家族 -->
                <div class="section" id="family-section">
                    <h2>扶養家族</h2>
                    <table>
                        <tr>
                            <th>関係</th>
                            <th>氏名</th>
                            <th>区分</th>
                            <th>住民登録番号</th>
                            <th>障害の有無</th>
                            <th>人的控除</th>
                            <th>健康保険</th>
                            <th>同居の有無</th>
                            <th>減免税</th>
                            <th>20歳以下の子供</th>
                        </tr>
                        <tr>
                            <td><select name="relationship[]"><option value="">選択</option></select></td>
                            <td><input type="text" name="name[]"></td>
                            <td><select name="type[]"><option value="">選択</option></select></td>
                            <td><input type="text" name="resident_registration_number[]"></td>
                            <td><input type="checkbox" name="disability[]" value="Y"></td>
                            <td><input type="checkbox" name="tax_deduction[]" value="Y"></td>
                            <td><input type="checkbox" name="health_insurance[]" value="Y"></td>
                            <td><input type="checkbox" name="cohabitation[]" value="Y"></td>
                            <td><input type="checkbox" name="tax_exempt[]" value="Y"></td>
                            <td><input type="checkbox" name="under_20_child[]" value="Y"></td>
                        </tr>
                        <!-- 追加行追加 -->
                    </table>
                    <button type="button">追加</button>
                    <button type="button">選択削除</button>
                </div>

                <!-- 学歴 -->
                <div class="section" id="education-section">
                    <h2>学歴</h2>
                    <table>
                        <tr>
                            <th>区分</th>
                            <th>入学年月</th>
                            <th>卒業年月</th>
                            <th>学校名</th>
                            <th>専攻</th>
                            <th>履修</th>
                        </tr>
                        <tr>
                            <td><select name="edu_type[]"><option value="">選択</option></select></td>
                            <td><input type="text" name="admission_date[]" placeholder="年-月"></td>
                            <td><input type="text" name="graduation_date[]" placeholder="年-月"></td>
                            <td><input type="text" name="school_name[]"></td>
                            <td><input type="text" name="major[]"></td>
                            <td><select name="completion_status[]"><option value="">選択</option></select></td>
                        </tr>
                        <!-- 追加行追加 -->
                    </table>
                    <button type="button">追加</button>
                    <button type="button">選択削除</button>
                </div>

                <!-- 経歴 -->
                <div class="section" id="career-section">
                    <h2>経歴</h2>
                    <table>
                        <tr>
                            <th>会社名</th>
                            <th>入社日</th>
                            <th>退社日</th>
                            <th>勤務期間</th>
                            <th>最終職位</th>
                            <th>担当業務</th>
                            <th>退職理由</th>
                        </tr>
                        <tr>
                            <td><input type="text" name="company_name[]"></td>
                            <td><input type="text" name="join_date[]" placeholder="年-月-日"></td>
                            <td><input type="text" name="leave_date[]" placeholder="年-月-日"></td>
                            <td><input type="text" name="work_period[]"></td>
                            <td><input type="text" name="last_position[]"></td>
                            <td><input type="text" name="responsibility[]"></td>
                            <td><input type="text" name="leave_reason[]"></td>
                        </tr>
                        <!-- 追加行追加 -->
                    </table>
                    <button type="button">追加</button>
                    <button type="button">選択削除</button>
                </div>

                <!-- 兵役 -->
                <div class="section" id="military-section">
                    <h2>兵役</h2>
                    <table>
                        <tr>
                            <th>兵役区分</th>
                            <th>軍別</th>
                            <th>服務期間（開始）</th>
                            <th>服務期間（終了）</th>
                            <th>最終階級</th>
                            <th>兵科</th>
                            <th>未履行理由</th>
                        </tr>
                        <tr>
                            <td><select name="military_type[]"><option value="">選択</option></select></td>
                            <td><select name="military_branch[]"><option value="">選択</option></select></td>
                            <td><input type="text" name="service_start[]" placeholder="年-月-日"></td>
                            <td><input type="text" name="service_end[]" placeholder="年-月-日"></td>
                            <td><input type="text" name="last_rank[]"></td>
                            <td><input type="text" name="military_field[]"></td>
                            <td><input type="text" name="no_service_reason[]"></td>
                        </tr>
                    </table>
                </div>

                <!-- 保存、キャンセル、リスト、新規社員登録ボタン -->
                <div class="buttons">
                    <button type="submit" formaction="EmployeeRegistrationController?action=save">保存</button>
                    <button type="submit" formaction="EmployeeRegistrationController?action=cancel">キャンセル</button>
                    <button type="button" onclick="location.href='EmployeeList.jsp'">リスト</button>
                    <button type="button" onclick="location.href='NewEmployee.jsp'">新規社員登録</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
