package jp.co.systena.tigerscave.BattleOfMonster.application.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.BattleOfMonster.application.lib.BattleForm;
import jp.co.systena.tigerscave.BattleOfMonster.application.lib.BattleServise;
import jp.co.systena.tigerscave.BattleOfMonster.application.model.battle.Battle;
import jp.co.systena.tigerscave.BattleOfMonster.application.model.monster.Monster;

@Controller  // Viewあり。Viewを返却するアノテーション
public class BattleController {

//  @ModelAttribute
//  BattleForm setUpForm () {
//    return new BattleForm();
//  }

  @Autowired
  HttpSession session;                  // セッション管理

  @Autowired
  JdbcTemplate jdbcTemplate;

  @RequestMapping(value="/battleofmonster", method = RequestMethod.GET)          // URLとのマッピング
  public ModelAndView show(ModelAndView mav) {
    // モンスター一覧を取得
    List<Map<String, Object>> monsterList = jdbcTemplate.queryForList("SELECT * FROM monster_status ORDER BY monster_id");
    session.setAttribute("monsterList", monsterList);
    List<Map<String, Object>> arts = jdbcTemplate.queryForList("SELECT * FROM monster_arts ORDER BY art_id");
    session.setAttribute("arts", arts);
    BattleForm battleForm = new BattleForm(monsterList);
    mav.addObject("battleForm", battleForm);
    // Viewのテンプレート名を設定
    mav.setViewName("monsterselect");
    return mav;
  }

  @RequestMapping(value="/battleofmonster", method = RequestMethod.POST)          // URLとのマッピング
  public ModelAndView battle(@ModelAttribute BattleForm battleForm, ModelAndView mav) {
    List<Map<String, Object>> monsterList = (List<Map<String, Object>>)session.getAttribute("monsterList");
    session.removeAttribute("monsterList");
    List<Map<String, Object>> arts = (List<Map<String, Object>>)session.getAttribute("arts");
    session.removeAttribute("arts");
    BattleServise battleServise = (BattleServise)session.getAttribute("battleServise");
    session.removeAttribute("battleServise");
    if (battleServise == null) {
      battleServise = new BattleServise();
    }
    battleServise.setAttackNumber(battleForm.getAttackNumber());

    // モンスター
    if (0 == battleServise.getBattleStatus()) {
      battleServise.setBattleStatus(1);
      for (Map<String, Object> monster : monsterList) {
        if (new Integer(monster.get("monster_id").toString()).intValue() == battleForm.getMonsterOneNumber()) {
          battleServise.setMonsterOne(new Monster(
            monster.get("monster_name").toString(),
            new Integer(monster.get("hit_point").toString()).intValue(),
            new Integer(monster.get("attack_point").toString()).intValue(),
            new Integer(monster.get("agility_point").toString()).intValue(),
            new Integer(monster.get("type").toString()).intValue(),
            new Integer(monster.get("art_one").toString()).intValue(),
            new Integer(monster.get("art_two").toString()).intValue(),
            new Integer(monster.get("art_three").toString()).intValue(),
            new Integer(monster.get("art_four").toString()).intValue(),
            arts
          ));
        }
        if (new Integer(monster.get("monster_id").toString()).intValue() == battleForm.getMonsterTwoNumber()) {
          battleServise.setMonsterTwo(new Monster(
            monster.get("monster_name").toString(),
            new Integer(monster.get("hit_point").toString()).intValue(),
            new Integer(monster.get("attack_point").toString()).intValue(),
            new Integer(monster.get("agility_point").toString()).intValue(),
            new Integer(monster.get("type").toString()).intValue(),
            new Integer(monster.get("art_one").toString()).intValue(),
            new Integer(monster.get("art_two").toString()).intValue(),
            new Integer(monster.get("art_three").toString()).intValue(),
            new Integer(monster.get("art_four").toString()).intValue(),
            arts
          ));
        }
      }
    }

    battleServise = Battle.play(battleServise);
    battleForm.setMonsterOne(battleServise.getMonsterOne());
    battleForm.setMonsterTwo(battleServise.getMonsterTwo());
    battleForm.setBattleLog(battleServise.getBattleLog());
    battleForm.setBattleStatus(battleServise.getBattleStatus());
    session.setAttribute("battleServise", battleServise);
    mav.addObject("battleForm", battleForm);
    if (1 == battleForm.getBattleStatus()) {
      mav.setViewName("battle");
    } else if (0 == battleForm.getBattleStatus()) {
      if (0 < battleForm.getMonsterOne().getHitPoint()) {
        mav.addObject("result", "勝利");
      } else {
        mav.addObject("result", "敗北");
      }
      mav.setViewName("end");
    }
    return mav;
  }

  @RequestMapping(value="/restart", method = RequestMethod.GET)          // URLとのマッピング
  public ModelAndView restart(ModelAndView mav) {
    session.removeAttribute("battleServise");
    return new ModelAndView("redirect:/battleofmonster");
  }
}
