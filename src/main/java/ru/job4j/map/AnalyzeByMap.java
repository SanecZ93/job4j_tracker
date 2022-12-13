package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        for (Pupil pupil : pupils) {
            for (SubjectOld subject : pupil.subjects()) {
                score += (double) subject.score() / (pupil.subjects().size() * pupils.size());
            }
        }
        return score;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (SubjectOld subject : pupil.subjects()) {
                score += (double) subject.score() / pupil.subjects().size();
            }
            labels.add(new Label(pupil.name(), score));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> label = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (SubjectOld subject : pupil.subjects()) {
                label.put(subject.name(), label.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String keys : label.keySet()) {
            labels.add(new Label(keys, (double) (label.get(keys)) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (SubjectOld subject : pupil.subjects()) {
                score += subject.score();
            }
            labels.add(new Label(pupil.name(), score));
            labels.sort(Comparator.naturalOrder());
        }
        return labels.get(pupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> label = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (SubjectOld subject : pupil.subjects()) {
                Integer score = subject.score();
                label.put(subject.name(), label.getOrDefault(subject.name(), 0) + score);
            }
        }
        for (String keys : label.keySet()) {
            labels.add(new Label(keys, (double) (label.get(keys))));
            labels.sort(Comparator.naturalOrder());
        }
        return labels.get(pupils.size() - 1);
    }
}