package jp.co.sample.point;

import javax.validation.Valid;

import jp.co.sample.dao.PointDao;
import jp.co.sample.model.Point;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/point")
public class PointController {

	@RequestMapping
	public String index(@ModelAttribute @Valid HomeForm form,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "home";
		}
		PointDao pointDao = new PointDao();
		Point point = new Point();
		point.setPoint(Integer.valueOf(form.getPoint()));
		point.setUser_id(Integer.valueOf(form.getUsers()));
		pointDao.addPoint(point);
		
		model.addAttribute("point", form.getPoint());
		return "point";
	}
}
