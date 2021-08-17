package PersistanceClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import PersistanceClasses.PersistanceClass;

@Entity        //It tells it is an Entity class
@Table(name="Players")   //Table Name
public class PersistanceClass {
	@Id         // primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // Auto Increment
	@Column(name="id")      //Column Name
	private int playerId;
	@Column(nullable=false,unique=true,name="name")
	private String playerName;
	@Column(name="teamname")
	private String teamName;
	@Column(name="age")
	private int age;
	public PersistanceClass() {
		
	}
	
	public PersistanceClass(String playerName, String teamName, int age) {
		super();
		this.playerName = playerName;
		this.teamName = teamName;
		this.age = age;
	}

	public PersistanceClass(int playerId, String playerName, String teamName, int age) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.teamName = teamName;
		this.age = age;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
