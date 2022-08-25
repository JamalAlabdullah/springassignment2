package no.noroff.accelerate.springassignment2.models;

import java.util.List;

public record CustomerGenre(int customerId, List<String> genreName) {
}
