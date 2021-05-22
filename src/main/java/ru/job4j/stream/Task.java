package ru.job4j.stream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task {

    static class Builder {

        private Long id;
        private Long teacherId;
        private Long studentId;
        private Integer disciplineId;
        private Long classId;
        private Long lessonId;
        private Integer workTypeId;
        private Integer workNum;
        private String description;
        private Date deadLine;
        private Date issued;
        private Date done;
        private Byte status;
        private Double mark;
        private String studentComment;
        private String teacherComment;
        private Long studentAttachId;
        private Long teacherAttachId;

        Builder buildId(long id) {
            this.id = id;
            return this;
        }

        Builder buildTeacherId(long teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        Builder buildStudentId(long studentId) {
            this.studentId = studentId;
            return this;
        }

        Builder buildDisciplineId(int disciplineId) {
            this.disciplineId = disciplineId;
            return this;
        }

        Builder buildClassId(long classId) {
            this.classId = classId;
            return this;
        }

        Builder buildLessonId(long lessonId) {
            this.lessonId = lessonId;
            return this;
        }

        Builder buildWorkTypeId(int workTypeId) {
            this.workTypeId = workTypeId;
            return this;
        }

        Builder buildWorkNum(int workNum) {
            this.workNum = workNum;
            return this;
        }

        Builder buildDescription(String description) {
            this.description = description;
            return this;
        }

        Builder buildDeadLine(Date deadLine) {
            this.deadLine = deadLine;
            return this;
        }

        Builder buildIssued(Date issued) {
            this.issued = issued;
            return this;
        }

        Builder buildDone(Date done) {
            this.done = done;
            return this;
        }

        Builder buildStatus(int status) {
            this.status = (byte) status;
            return this;
        }

        Builder buildMark(double mark) {
            this.mark = mark;
            return this;
        }

        Builder buildStudentComment(String studentComment) {
            this.studentComment = studentComment;
            return this;
        }

        Builder buildTeacherComment(String teacherComment) {
            this.teacherComment = teacherComment;
            return this;
        }

        Builder buildStudentAttachId(Long attachId) {
            this.studentAttachId = attachId;
            return this;
        }

        Builder buildTeacherAttachId(Long attachId) {
            this.teacherAttachId = attachId;
            return this;
        }

        Task build() {
            Task task = new Task();
            task.id = id;
            task.teacherId = teacherId;
            task.studentId = studentId;
            task.disciplineId = disciplineId;
            task.classId = classId;
            task.lessonId = lessonId;
            task.workTypeId = workTypeId;
            task.workNum = workNum;
            task.description = description;
            task.deadLine = deadLine;
            task.issued = issued;
            task.done = done;
            task.status = status;
            task.mark = mark;
            task.studentComment = studentComment;
            task.teacherComment = teacherComment;
            task.studentAttachId = studentAttachId;
            task.teacherAttachId = teacherAttachId;
            return task;
        }
    }

    private Long id;
    private Long teacherId;
    private Long studentId;
    private Integer disciplineId;
    private Long classId;
    private Long lessonId;
    private Integer workTypeId;
    private Integer workNum;
    private String description;
    private Date deadLine;
    private Date issued;
    private Date done;

    /**
     * Статусы задачи:
     * 0 - выдана для исполнения
     * 1 - сдана на проверку
     * 2 - возвращена на доработку
     * 3 - закрыта и оценена
     */
    private Byte status;
    private Double mark;
    private String studentComment;
    private String teacherComment;
    private Long studentAttachId;
    private Long teacherAttachId;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(int workTypeId) {
        this.workTypeId = workTypeId;
    }

    public Integer getWorkNum() {
        return workNum;
    }

    public void setWorkNum(int workNum) {
        this.workNum = workNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public Date getDone() {
        return done;
    }

    public void setDone(Date done) {
        this.done = done;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getStudentComment() {
        return studentComment;
    }

    public void setStudentComment(String studentComment) {
        this.studentComment = studentComment;
    }

    public String getTeacherComment() {
        return teacherComment;
    }

    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment;
    }

    public Long getStudentAttachId() {
        return studentAttachId;
    }

    public void setStudentAttachId(long studentAttachId) {
        this.studentAttachId = studentAttachId;
    }

    public Long getTeacherAttachId() {
        return teacherAttachId;
    }

    public void setTeacherAttachId(long teacherAttachId) {
        this.teacherAttachId = teacherAttachId;
    }

    @Override
    public String toString() {
        DateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        return
                "Task {"
                + "id=" + id
                + ", teacherId=" + teacherId
                + ", studentId=" + studentId
                + ", disciplineId=" + disciplineId
                + ", classId=" + classId
                + ", lessonId=" + lessonId
                + ", workTypeId=" + workTypeId
                + ", workNum=" + workNum
                + ", description='" + description + '\''
                + ", deadLine=" + f.format(deadLine)
                + ", issued=" + f.format(issued)
                + ", done=" + f.format(done)
                + ", status=" + status
                + ", mark=" + mark
                + ", studentComment='" + studentComment + '\''
                + ", teacherComment='" + teacherComment + '\''
                + ", studentAttachId=" + studentAttachId
                + ", teacherAttachId=" + teacherAttachId
                + '}';
    }
}
