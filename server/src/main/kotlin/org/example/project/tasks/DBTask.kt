package org.example.project.tasks

import kotlinx.datetime.toKotlinLocalDateTime
import org.example.project.db.PostDAO
import org.example.project.db.RatingDAO
import org.example.project.db.TagDAO
import org.example.project.db.UserDAO
import org.example.project.initDB
import org.example.project.model.Tag
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import java.time.LocalDateTime

fun main() {
    initDB(resetDB = true)
    transaction {
        val user1 = UserDAO.new {
            email = "max.mustermann@test.de"
            firstName = "Max"
            lastName = "Mustermann"
            verified = false
        }
        val user2 = UserDAO.new {
            email = "maria.musterfrau@test.de"
            firstName = "Maria"
            lastName = "Musterfrau"
            verified = false
        }
        val user3 = UserDAO.new {
            email = "justus.biber@test.de"
            firstName = "Justus"
            lastName = "Biber"
            verified = false
        }
        val user4 = UserDAO.new {
            email = "franziska.otter@test.de"
            firstName = "Franziska"
            lastName = "Otter"
            verified = false
        }
        val user5 = UserDAO.new {
            email = "elena.tauber@test.de"
            firstName = "Elena"
            lastName = "Tauber"
            verified = false
        }
        val user6 = UserDAO.new {
            email = "felipe.claudio@test.de"
            firstName = "Felipe"
            lastName = "Claudio"
            verified = false
        }
        val munich = UserDAO.new {
            email = "munich@test.de"
            firstName = "City of"
            lastName = "Munich"
            verified = true
        }
        val bavaria = UserDAO.new {
            email = "bavaria@test.de"
            firstName = "State of"
            lastName = "Bavaria"
            verified = true
        }

        val post1 = PostDAO.new {
            title = "Election Results"
            description =
                "Here you can find the results of the current election. Et magnis dis parturient montes nascetur ridiculus mus. Interdum tortor ligula congue sollicitudin erat viverra ac. Accumsan maecenas potenti ultricies habitant morbi senectus netus. Pulvinar vivamus fringilla lacus nec metus bibendum egestas."
            createdAt = LocalDateTime.now().toKotlinLocalDateTime()
            createdBy = munich.id
        }
        val post2 = PostDAO.new {
            title = "Lorem ipsum dolor sit amet"
            description =
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            createdAt = LocalDateTime.now().minusDays(1).toKotlinLocalDateTime()
            createdBy = munich.id
        }
        val post3 = PostDAO.new {
            title = "Quisque faucibus ex sapien vitae pellentesque sem placerat"
            description =
                "In id cursus mi pretium tellus duis convallis. Tempus leo eu aenean sed diam urna tempor. Pulvinar vivamus fringilla lacus nec metus bibendum egestas. Iaculis massa nisl malesuada lacinia integer nunc posuere. Ut hendrerit semper vel class aptent taciti sociosqu. Ad litora torquent per conubia nostra inceptos himenaeos."
            createdAt = LocalDateTime.now().minusDays(3).toKotlinLocalDateTime()
            createdBy = user1.id
        }
        val post4 = PostDAO.new {
            title = "Cras eleifend turpis fames primis vulputate ornare sagittis"
            description =
                "Sem placerat in id cursus mi pretium tellus. Orci varius natoque penatibus et magnis dis parturient. Finibus facilisis dapibus etiam interdum tortor ligula congue. Proin libero feugiat tristique accumsan maecenas potenti ultricies. Sed diam urna tempor pulvinar vivamus fringilla lacus. Eros lobortis nulla molestie mattis scelerisque maximus eget. Porta elementum a enim euismod quam justo lectus. Curabitur facilisi cubilia curae hac habitasse platea dictumst. Nisl malesuada lacinia integer nunc posuere ut hendrerit. Efficitur laoreet mauris pharetra vestibulum fusce dictum risus. "
            createdAt = LocalDateTime.now().minusDays(7).toKotlinLocalDateTime()
            createdBy = user1.id
        }
        val post5 = PostDAO.new {
            title = "Imperdiet mollis nullam volutpat porttitor ullamcorper rutrum gravida"
            description =
                "Ut dipiscing elit quisque faucibus ex sapien vitae pellentesque. Ad litora torquent per conubia nostra inceptos himenaeos. Consequat magna ante condimentum neque at luctus nibh. Ornare sagittis vehicula praesent dui felis venenatis ultrices. Pretium tellus duis convallis tempus leo eu aenean. Dis parturient montes nascetur ridiculus mus donec rhoncus. Ligula congue sollicitudin erat viverra ac tincidunt nam. Potenti ultricies habitant morbi senectus netus suscipit auctor."
            createdAt = LocalDateTime.now().minusDays(8).toKotlinLocalDateTime()
            createdBy = user2.id
        }
        val post6 = PostDAO.new {
            title = "Pringilla lacus nec metus bibendum egestas iaculis massa"
            description =
                "Maximus eget fermentum odio phasellus non purus est. Justo lectus commodo augue arcu dignissim velit aliquam. Platea dictumst lorem ipsum dolor sit amet consectetur. Ut hendrerit semper vel class aptent taciti sociosqu. Dictum risus blandit quis suspendisse aliquet nisi sodales. Rutrum gravida cras eleifend turpis fames primis vulputate. Vitae pellentesque sem placerat in id cursus mi. Inceptos himenaeos orci varius natoque penatibus et magnis. Luctus nibh finibus facilisis dapibus etiam interdum tortor. "
            createdAt = LocalDateTime.now().minusDays(15).toKotlinLocalDateTime()
            createdBy = user2.id
        }
        val post7 = PostDAO.new {
            title = "Venenatis ultrices proin libero feugiat tristique accumsan maecenas"
            description =
                "Eu aenean sed diam urna tempor pulvinar vivamus. Donec rhoncus eros lobortis nulla molestie mattis scelerisque. Tincidunt nam porta elementum a enim euismod quam. Suscipit auctor curabitur facilisi cubilia curae hac habitasse. Iaculis massa nisl malesuada lacinia integer nunc posuere. Purus est efficitur laoreet mauris pharetra vestibulum fusce. Velit aliquam imperdiet mollis nullam volutpat porttitor ullamcorper. Amet consectetur adipiscing elit quisque faucibus ex sapien. Taciti sociosqu ad litora torquent per conubia nostra. Nisi sodales consequat magna ante condimentum neque at. Primis vulputate ornare sagittis vehicula praesent dui felis. Cursus mi pretium tellus duis convallis tempus leo."
            createdAt = LocalDateTime.now().minusDays(20).toKotlinLocalDateTime()
            createdBy = bavaria.id
        }

        val rating1 = RatingDAO.new {
            user = user1.id
            post = post1.id
            rating = 1
        }
        val rating2 = RatingDAO.new {
            user = user2.id
            post = post1.id
            rating = 1
        }
        val rating3 = RatingDAO.new {
            user = user3.id
            post = post1.id
            rating = 1
        }
        val rating4 = RatingDAO.new {
            user = user4.id
            post = post1.id
            rating = 1
        }
        val rating5 = RatingDAO.new {
            user = user5.id
            post = post1.id
            rating = -1
        }
        val rating6 = RatingDAO.new {
            user = user1.id
            post = post2.id
            rating = -1
        }
        val rating7 = RatingDAO.new {
            user = user2.id
            post = post2.id
            rating = -1
        }
        val rating8 = RatingDAO.new {
            user = user3.id
            post = post2.id
            rating = -1
        }
        val rating9 = RatingDAO.new {
            user = user4.id
            post = post3.id
            rating = 1
        }
        val rating10 = RatingDAO.new {
            user = user5.id
            post = post3.id
            rating = 1
        }
        val rating11 = RatingDAO.new {
            user = user1.id
            post = post4.id
            rating = 1
        }
        val rating12 = RatingDAO.new {
            user = user2.id
            post = post4.id
            rating = 1
        }
        val rating13 = RatingDAO.new {
            user = user3.id
            post = post4.id
            rating = -1
        }
        val rating14 = RatingDAO.new {
            user = user4.id
            post = post4.id
            rating = -1
        }
        val rating15 = RatingDAO.new {
            user = user5.id
            post = post5.id
            rating = 1
        }
        val rating16 = RatingDAO.new {
            user = user1.id
            post = post5.id
            rating = 1
        }
        val rating17 = RatingDAO.new {
            user = user2.id
            post = post6.id
            rating = 1
        }
        val rating18 = RatingDAO.new {
            user = user3.id
            post = post6.id
            rating = -1
        }
        val rating19 = RatingDAO.new {
            user = user4.id
            post = post1.id
            rating = -1
        }

        val tag1 = TagDAO.new {
            post = post1.id
            tag = Tag.ENVIRONMENT
        }
        val tag2 = TagDAO.new {
            post = post1.id
            tag = Tag.OFFICIAL
        }
        val tag3 = TagDAO.new {
            post = post1.id
            tag = Tag.TRANSPORT
        }
        val tag4 = TagDAO.new {
            post = post1.id
            tag = Tag.EVENTS
        }
        val tag5 = TagDAO.new {
            post = post1.id
            tag = Tag.FINANCE
        }
        val tag6 = TagDAO.new {
            post = post2.id
            tag = Tag.ENVIRONMENT
        }
        val tag7 = TagDAO.new {
            post = post2.id
            tag = Tag.FINANCE
        }
        val tag8 = TagDAO.new {
            post = post3.id
            tag = Tag.EVENTS
        }
        val tag9 = TagDAO.new {
            post = post5.id
            tag = Tag.ENVIRONMENT
        }
        val tag10 = TagDAO.new {
            post = post5.id
            tag = Tag.TRANSPORT
        }
    }
}
