package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "QUESTIONSQUIZ")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Table(name = "QUIZ_QEUSTIONS_TABLE")
public class QuestionsQuiz implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQuestion; 
	@Column(length = 3000)
	private String nameQuestion; 
	@Column(length = 3000)
	private String QuestionContent;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idQuiz")
	private Quiz quiz ;
	@OneToMany(targetEntity=AnswerQuiz.class, mappedBy="questions")
    @JsonIgnore
	private List<AnswerQuiz> answer = new ArrayList<>();
}
