package com.itwillbs.Code_Green.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.itwillbs.Code_Green.service.KakaoService;
import com.itwillbs.Code_Green.service.MemberService;
import com.itwillbs.Code_Green.vo.MemberVO;

@Controller
public class LoginController {

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@Autowired
	private MemberService service;
	@Autowired
	private KakaoService kService;

//	 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

//		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		System.out.println("네이버:" + naverAuthUrl);

//		// 네이버
		model.addAttribute("url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "member/login";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "member/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		System.out.println("여기는 callback");

		OAuth2AccessToken oauthToken;

		oauthToken = naverLoginBO.getAccessToken(session, code, state);

		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터

		// 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;

		// 3. 데이터 파싱
		// Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");

		// response의 값 파싱
		String member_name = (String) response_obj.get("name");
		String member_id = (String) response_obj.get("email");
		String member_phone = (String) response_obj.get("mobile");
		String member_email = (String) response_obj.get("email");

		// MemberVO 객체에 저장
		MemberVO member = new MemberVO();
		member.setMember_name(member_name);
		member.setMember_id(member_id);
		member.setMember_phone(member_phone);
		member.setMember_email(member_id);

		// 회원 유무 확인
		MemberVO existMember = service.getMemberInfo(member_id);

		if (existMember == null) {
			int insertCount = service.joinMember(member);

			if (insertCount == 0) {
				model.addAttribute("msg", "회원가입 실패");
				return "member/fail_back";
			}
		}

//			Session 객체에 저장
		MemberVO getMem = service.getMemberInfo(member.getMember_id());
		session.setAttribute("sId", member.getMember_id()); // 세션아이디
		session.setAttribute("sIdx", getMem.getMember_idx());// 세션 IDX
		session.setAttribute("sEmail", getMem.getMember_email()); // 세션 이메일

		model.addAttribute("result", apiResult);

		/* 네이버 로그인 성공 페이지 View 호출 */

		return "redirect:/";

	}
}
