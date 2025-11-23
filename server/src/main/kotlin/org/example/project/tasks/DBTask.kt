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
            title = "Should Munich host the Olympic games?"
            description =
                "The last time Munich hosted the Games, in 1972, the event left a lasting mark on the city: architectural innovation, improved infrastructure, and a culture of openness which Munich is still well-known for fifty years later. Today, as Munich considers a new application for one of the years 2036, 2040 or 2044, the implications once again reach far beyond sport: long-term urban development, transport infrastructure, environmental impact, economic investment, and the international visibility of Munich. These are matters that extend far beyond a single event; they influence the city for decades.\n" +
                        "For this reason, the upcoming petition plays a central role. The city has committed to ensuring that the application is anchored in a transparent process. Participating in the vote means taking an active role in shaping the future of the city. Whether you view the Olympic project with optimism, caution, or skepticism, your perspective deserves to be represented in the final outcome. A clear and broad voter turnout strengthens the legitimacy of the decision and ensures that it reflects the will of the citizens as a whole.\n" +
                        "So, don't forget to participate in the petition - either at your polling place on Sunday or even beforehand by absentee ballot."
            createdAt = LocalDateTime.now().toKotlinLocalDateTime()
            createdBy = munich.id
        }
        val post2 = PostDAO.new {
            title = "Fully autonomous subways"
            description =
                "The idea of fully autonomous subways raises both excitement and concern. On one hand, driverless trains could improve efficiency, reduce delays, and operate more safely through advanced sensors and automation. On the other hand, many worry about technical failures, cybersecurity risks, and the loss of human presence during emergencies. Whether subways should run without a human ultimately depends on balancing innovation with safety, trust, and the needs of passengers." +
                        "What do you think about it? Can you imagine to take a fully autonomous subway?"
            createdAt = LocalDateTime.now().minusDays(1).toKotlinLocalDateTime()
            createdBy = munich.id
        }
        val post3 = PostDAO.new {
            title = "District commitee of Schwabing"
            description =
                "This Friday, there will be the next meeting of the district committee of Schwabing. One important point of the meeting will be the increasing shortage of living space in our district and on how we as the district committee can tackle this problem;" +
                        "you can find the whole agenda on our website. Please note that the meeting is open to everyone, we are always happy about attendees, independent on whether you just want to actively listen or even contribute to finding solutions to the issues in our district." +
                        "If there are further topics which you want to discuss in the next meeting, feel free to write as an email or contact us in some other way (for detailed information, please see our website)."
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
