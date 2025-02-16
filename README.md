# One-to-One Chat Application

## Overview
The **One-to-One Chat Application** is a real-time messaging platform built using **Spring Boot, WebSockets, and MongoDB**. It enables seamless one-on-one communication between users with persistent chat history.

## Features
- **Real-time Messaging** – Enables instant message delivery using WebSockets.
- **Chat History Storage** – Stores and retrieves chat messages efficiently using MongoDB.
- **WebSocket-Based Communication** – Maintains a continuous connection for low-latency message exchange.
- **Scalable Backend** – Built with Spring Boot and MongoDB for high performance and efficient handling of multiple active chats.

## Tech Stack
- **Backend**: Spring Boot, WebSockets
- **Database**: MongoDB
- **Messaging Protocol**: STOMP over WebSockets

## Setup & Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/premlalwani09/OneToOneChatApplication.git
   cd OneToOneChatApplication
   ```
2. Configure MongoDB in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/chatDB
   ```
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. Access WebSocket endpoint at:
   ```
   ws://localhost:8088
   ```

## API Endpoints
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/sendMessage` | POST | Sends a chat message |
| `/getMessages/{userId}` | GET | Retrieves chat history |

## How It Works
1. A WebSocket connection is established between clients and the server.
2. Messages are sent via WebSocket and stored in MongoDB.
3. Users can retrieve chat history anytime from the database.

## Future Enhancements
- **User Authentication** using JWT
- **Typing Indicators** for better UX
- **Online/Offline Status Tracking**
