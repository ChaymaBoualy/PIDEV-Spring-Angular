package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "RESERVATION")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Table(name = "RESERVATION_TABLE")
public class Reservation implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idReservation; 
		@Temporal(TemporalType.DATE)
		private Date dateReservation; 
		private Date dateEvent;
		@JsonIgnore
		private int idDocument;
		@Column(length = 3000)
		@JsonIgnore
		private String documentName;
		@Column(length = 3000)
		@JsonIgnore
		private String documentType;
		@Column(length = 3000)
		@JsonIgnore
		@Lob
		private byte[] dataDocument;
		@JsonIgnore
		private int idImage;
		@Column(length = 3000)
		@JsonIgnore
		private String imageName;
		@JsonIgnore
		@Column(length = 3000)
		private String imageType;
		@JsonIgnore
		@Column(length = 3000)
		private String imageURL;
		@JsonIgnore
		@Lob
		private byte[] dataImage;
		@ManyToMany
		@JsonIgnore
	    Set<User> users;
		

}
