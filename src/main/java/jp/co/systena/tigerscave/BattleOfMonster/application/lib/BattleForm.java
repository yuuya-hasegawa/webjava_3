package jp.co.systena.tigerscave.BattleOfMonster.application.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.systena.tigerscave.BattleOfMonster.application.model.monster.Monster;

public class BattleForm {
  private int monsterOneNumber;
  private int monsterTwoNumber;
  private int battleStage;
  private int attackNumber;
  private List<Map<String, Object>> monsterList;
  private Monster monsterOne;
  private Monster monsterTwo;
  private ArrayList<String> battleLog = new ArrayList<String>(); // [対戦ログ]
  private int battleStatus = 0; // [対戦状況] 1: 対戦中, 0: 対戦前/対戦終了

  public BattleForm(List<Map<String, Object>> monsterList) {
    this.monsterList = monsterList;
  }

  public int getMonsterOneNumber() {
    return this.monsterOneNumber;
  }

  public void setMonsterOneNumber(int monsterOneNumber) {
    this.monsterOneNumber = monsterOneNumber;
  }

  public int getMonsterTwoNumber() {
    return this.monsterTwoNumber;
  }

  public void setMonsterTwoNumber(int monsterTwoNumber) {
    this.monsterTwoNumber = monsterTwoNumber;
  }

  public Monster getMonsterOne() {
    return this.monsterOne;
  }

  public void setMonsterOne(Monster monsterOne) {
    this.monsterOne = monsterOne;
  }

  public Monster getMonsterTwo() {
    return this.monsterTwo;
  }

  public void setMonsterTwo(Monster monsterTwo) {
    this.monsterTwo = monsterTwo;
  }

  public int getBattleStage() {
    return this.battleStage;
  }

  public void setBattleStage(int battleStage) {
    this.battleStage = battleStage;
  }

  public int getAttackNumber() {
    return this.attackNumber;
  }

  public void setAttackNumber(int attackNumber) {
    this.attackNumber = attackNumber;
  }

  public List<Map<String, Object>> getMonsterList() {
    return monsterList;
  }

  public void setMonsterList(List<Map<String, Object>> monsterList) {
    this.monsterList = monsterList;
  }

  public ArrayList<String> getBattleLog() {
    return this.battleLog;
  }

  public void setBattleLog(ArrayList<String> battleLog) {
    this.battleLog = battleLog;
  }

  public int getBattleStatus() {
    return this.battleStatus;
  }

  public void setBattleStatus(int battleStatus) {
    this.battleStatus = battleStatus;
  }
}
