package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = {
                                                CascadeType.DETACH,
                                                CascadeType.MERGE,
                                                CascadeType.PERSIST,
                                                CascadeType.REFRESH
                                            })
    private Instructor instructor;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.hobby = hobby;
        this.youtubeChannel = youtubeChannel;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the youtubeChannel
     */
    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    /**
     * @param youtubeChannel the youtubeChannel to set
     */
    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    /**
     * @return String return the hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param hobby the hobby to set
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString(){
        return "InstructorDetail [id="+id+", youtubeChannel="+youtubeChannel+", hobby="+hobby+"]"; 
    }

    /**
     * @return Instructor return the instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}