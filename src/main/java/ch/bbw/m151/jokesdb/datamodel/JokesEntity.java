package ch.bbw.m151.jokesdb.datamodel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jokes")
@Getter
@Setter
public class JokesEntity {

	@Id
	@GeneratedValue
	int id;

	@Column(nullable = true, length = 500)
	String joke;
	LocalDate timestamp;
	LocalDate modifiedTimestamp;
	String category;
}
